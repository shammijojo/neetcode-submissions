class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0],intervals[0][1]});

        for(int i = 1; i < intervals.length; i++) {
            int x = result.get(result.size()-1)[0];
            int y = result.get(result.size()-1)[1];

            if(intervals[i][0] <= y) {
                result.set(result.size()-1,new int[]{x,Math.max(y,intervals[i][1])});
            } else {
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
