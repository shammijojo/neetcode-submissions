class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];

        nextSmallestElementR(heights,right);
        nextSmallestElementL(heights,left);
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int area = (right[i]-left[i]+1)*heights[i];
           // System.out.println(i+" "+right[i]+" "+left[i]+" "+area);
            max = Math.max(area,max);
        }

        return max;
    }

    private void nextSmallestElementR(int[] height, int[] right) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(0);

        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                right[stack.pop()] = i-1;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            right[stack.pop()]=height.length-1;
        }
    }

    private void nextSmallestElementL(int[] height, int[] left) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(height.length-1);

        for(int i = height.length-1; i >=0 ; i--) {
            while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                left[stack.pop()] = i+1;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            left[stack.pop()]=0;
        }
    }





}
