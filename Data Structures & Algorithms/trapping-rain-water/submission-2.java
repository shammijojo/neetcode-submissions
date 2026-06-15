class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        
        if(right <= 1) return 0;

        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        left++;
        right--;

        while(left <= right) {
            if(leftMax > rightMax) {
                water += Math.max(0,rightMax-height[right]);
                rightMax = Math.max(rightMax,height[right]);
                right--;
            } else {
                water += Math.max(0,leftMax-height[left]);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }
            System.out.println(water);
        }

        return water;
    }
}
