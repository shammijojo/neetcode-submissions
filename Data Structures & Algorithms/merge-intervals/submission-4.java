class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(!stack.isEmpty() && stack.peek()[1]  >= intervals[i][0]) {
                int[] top = stack.pop();
                stack.add(new int[]{top[0],Math.max(top[1],intervals[i][1])});
            } else {
                stack.add(intervals[i]);
            }
        }

        int[][] result = new int[stack.size()][2];
        int k = stack.size()-1;
        while(!stack.isEmpty()) {
            result[k] = stack.pop();
            k--;
        }

        return result;

    }
}
