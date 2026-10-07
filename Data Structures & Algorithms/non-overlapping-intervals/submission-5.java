class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int[] lastInterval = intervals[0];
        int erased = 0;

        for(int i = 1; i < intervals.length; i++) {
            int lastIntervalEnd = lastInterval[1];
            int currentIntervalEnd = intervals[i][1];

            if(lastIntervalEnd > intervals[i][0]) {
                if(lastIntervalEnd > currentIntervalEnd) {
                    lastInterval = intervals[i];
                }
                erased++;
            } else {
                lastInterval = intervals[i];
            }
        }

        return erased;

    }
}
