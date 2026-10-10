class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while(right < nums.length) {
            sum += nums[right];

            while(left <= right && sum >= target) {
                min = Math.min(min, right-left+1);
                sum -= nums[left++];
            }

            right++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}