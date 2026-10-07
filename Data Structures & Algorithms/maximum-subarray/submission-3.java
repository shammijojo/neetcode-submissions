class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            max = Math.max(max,currentSum);

            currentSum = Math.max(0,currentSum);
        }

        return max;
    }
}
