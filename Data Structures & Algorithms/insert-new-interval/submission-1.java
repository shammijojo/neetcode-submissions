class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Collections.sort(intervals, (a,b) -> a.start-b.start);

        int startTime = newInterval[0];
        int endTime = newInterval[1];
        int i = 0;
        List<int[]> result = new ArrayList<>();

        while(i < intervals.length && intervals[i][1] < startTime) {
            result.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= endTime) {
            startTime = Math.min(startTime, intervals[i][0]);
            endTime = Math.max(endTime,intervals[i][1]);
            i++;
        }
        result.add(new int[]{startTime,endTime});

        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }


        return result.toArray(new int[0][]);


    }
}
