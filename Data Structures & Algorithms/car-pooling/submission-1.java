class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> points = new ArrayList<>();

        for(int i = 0; i < trips.length; i++) {
            points.add(new int[]{trips[i][1],trips[i][0]});
            points.add(new int[]{trips[i][2],-trips[i][0]});
        }

        Collections.sort(points,(a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int currentPassengers = 0;
        for(int[] point : points) {
            currentPassengers += point[1];
            if(currentPassengers > capacity) {
                return false;
            }
        }

        return true;

        
    }
}