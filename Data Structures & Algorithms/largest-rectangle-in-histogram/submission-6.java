class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        nextSmallestHeightToLeft(left,heights);
        nextSmallestHeightToRight(right,heights);

        int max = 0;

        for(int i = 0; i < n; i++) {
            int width = left[i]-right[i]+1;
            int height = heights[i]*width;
            // System.out.println(left[i]+" "+right[i]);
            // System.out.println(height);
            max = Math.max(max,height);
        }

        return max;
    }

    private void nextSmallestHeightToLeft(int[] left, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = stack.pop();
                left[h] = i-1;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            left[stack.pop()] = heights.length-1;
        }
    }

    private void nextSmallestHeightToRight(int[] right, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length-1);

        for(int i = heights.length-2; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = stack.pop();
                right[h] = i+1;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            right[stack.pop()] = 0;
        }
    }
}
