class Solution {
    public int trap(int[] height) {
       int n = height.length;

        if(n<=2) {
            return 0;
        }

       int leftMax = height[0], rightMax = height[n-1];

        int left = 1, right = n-2;
        int trappedWater = 0;

        while(left <= right) {
            if(leftMax > rightMax) {
                trappedWater += Math.max(0,rightMax-height[right]); 
                rightMax = Math.max(rightMax,height[right]);
                right--;
            } else {
                trappedWater += Math.max(0,leftMax-height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
        }

        return trappedWater;
    }
}
