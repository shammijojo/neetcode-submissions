class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        list.add(intervals[0]);
        int[] lastInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= lastInterval[1]) {
                int endTime = Math.max(intervals[i][1],lastInterval[1]);
                list.set(list.size()-1, new int[]{lastInterval[0],endTime});
                lastInterval = new int[]{lastInterval[0],endTime};
            } else {
                list.add(intervals[i]);
                lastInterval = intervals[i];
            }
        }

        return list.toArray(new int[0][]);
    }
}
