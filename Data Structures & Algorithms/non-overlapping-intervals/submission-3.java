class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int index = 0;
        int count = 0;

        for(int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];

            if(x < intervals[index][1]) {
                if(y < intervals[index][1]) {
                    index = i;
                }
                count++;
            } else {
                index = i;
            }
        }

        return count;
    }
}
