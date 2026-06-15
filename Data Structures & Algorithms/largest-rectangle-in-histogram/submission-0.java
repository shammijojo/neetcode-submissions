class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];

        nextSmallestElementR(heights,right);
        nextSmallestElementL(heights,left);
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int area = (right[i]-1-(left[i]+1)+1)*heights[i];
           // System.out.println(i+" "+right[i]+" "+left[i]+" "+area);
            max = Math.max(area,max);
        }

        return max;
    }

    private void nextSmallestElementR(int[] height, int[] right) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(0);

        for(int i = 0; i < height.length; i++) {
            right[i] = i+1;
            while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            right[stack.pop()]=height.length;
        }
    }

    private void nextSmallestElementL(int[] height, int[] left) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(height.length-1);

        for(int i = height.length-1; i >=0 ; i--) {
            left[i] = i-1;
            while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            left[stack.pop()]=-1;
        }
    }





}
