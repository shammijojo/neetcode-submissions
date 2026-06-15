class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        findNextSmallestRight(heights, right);
        findNextSmallestLeft(heights, left);

        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int area = ((right[i]-1)-(left[i]+1)+1)*heights[i];
            max = Math.max(max,area);
        }

        return max;

    }

    private void findNextSmallestRight(int[] heights, int[] right) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            right[stack.pop()] = heights.length;
        }
    }

    private void findNextSmallestLeft(int[] heights, int[] left) {
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
    }
}
