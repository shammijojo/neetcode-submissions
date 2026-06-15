class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;

        while(left < right) {
            int area = 0;
            if(height[left] < height[right]) {
                area = height[left]*(right-left);
                left++;
            } else {
                area = height[right]*(right-left);
                right--;
            }
            System.out.println(area);
            max = Math.max(max,area);
        }

        return max;
    }
}
