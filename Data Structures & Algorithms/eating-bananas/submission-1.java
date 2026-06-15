class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];
        int min = end;

        while(start <= end) {
            int k = (start+end)/2;
            int time = getTimeTaken(k,piles);
            if(time > h) {
                start = k+1;
            } else {
                min = Math.min(min,k);
                end = k-1;
            }
        }

        return min;

    }


    private int getTimeTaken(int k, int[] piles) {
        int time = 0;
        for(int x : piles) {
            time += Math.ceil((double)x/k);
        }
        return time;
    }
}
