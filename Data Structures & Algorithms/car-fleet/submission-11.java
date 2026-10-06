class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] arr = new int[n][2];

        for(int i = 0 ; i < speed.length; i++) {
            arr[i][0] = target-position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        double lastTime = (double)arr[0][0]/arr[0][1];
        // System.out.println(lastTime);
        int fleet = 1;

        for(int i = 1; i < n; i++) {
            double time = (double)arr[i][0]/arr[i][1];
            // System.out.println(time);
            if(time > lastTime) {
                fleet++;
                lastTime = time;
            }
            
        }

        return fleet;
    }
}
