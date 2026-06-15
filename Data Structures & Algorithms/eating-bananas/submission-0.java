class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];
        int k = (start+end)/2;
        int min = Integer.MAX_VALUE;

        while(start <= end) {
            int time = getTime(k,piles);
            if(time > h) {
                start = k+1;
            } else {
                min = Math.min(min,k);
                end = k-1;
            }
            k = (start+end)/2;
        }

        return min;
    }

    private int getTime(int k, int[] piles) {
        int time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += Math.ceil((double)piles[i]/k);
        }
        return time;
    }








}
