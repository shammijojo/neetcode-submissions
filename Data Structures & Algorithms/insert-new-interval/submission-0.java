class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        int x = newInterval[0];
        int y = newInterval[1];
        while(i < intervals.length && y >= intervals[i][0]) {
            x = Math.min(x,intervals[i][0]);
            y = Math.max(y,intervals[i][1]);
            i++;
        }
        result.add(new int[]{x,y});

        while(i < intervals.length) {
            result.add(intervals[i++]);
        }

        int[][] resultArray = new int[result.size()][2];
        for(int j = 0 ; j < result.size(); j++) {
            resultArray[j] = result.get(j);
        }

        return resultArray;


    }
}
