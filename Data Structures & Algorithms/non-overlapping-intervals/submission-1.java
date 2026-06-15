class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(!stack.isEmpty()) {
                int[] top = stack.peek();
                if(top[1] > intervals[i][0]) {
                    if(top[1] > intervals[i][1]) {
                        stack.pop();
                    } else {
                        continue;
                    }
                }
            }
            stack.push(intervals[i]);
        }

        return intervals.length-stack.size();
    }
}
