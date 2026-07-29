class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];

        findNextSmallestRight(heights,right);
        findNextSmallestLeft(heights,left);
        int max = 0;

        for(int i = 0; i < n; i++) {
            int area = (right[i]-left[i]-1) * heights[i];
            max = Math.max(max,area);
        }

        return max;
    }


    private void findNextSmallestRight(int[] heights, int[] right) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            right[stack.pop()] = heights.length;
        }
    }

     private void findNextSmallestLeft(int[] heights, int[] left) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        stack.add(n-1);

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
    }
}
