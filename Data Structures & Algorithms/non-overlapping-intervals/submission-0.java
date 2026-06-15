class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] i1 = stack.peek();
            int[] i2 = intervals[i];

            if(i2[0] < i1[1]) {
                if(i1[1] > i2[1]) {
                    stack.pop();
                    stack.push(i2);
                }
            } else {
                stack.push(i2);
            }
        }

        return intervals.length-stack.size();
    }
}
