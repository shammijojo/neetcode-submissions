class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        //excluding first house and including first house
        dp[0] = 0;
        dp[1] = nums[1];
        
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        //including first house and excluding last house
        int[] dp1 = new int[nums.length];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < nums.length-1; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }

        return Math.max(dp[nums.length-1],dp1[nums.length-2]);
    }
}
