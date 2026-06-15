class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }


        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int max = Math.max(dp[0],dp[1]);

        if(n ==2) return Math.max(dp[0],dp[1]);

        //Incuding first house and excluding last house
        for(int i = 2; i < n-1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = Math.max(max,dp[i]);
        }


        //Excluding first house and including last house
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-1],nums[n-2]);
        max = Math.max(max,dp[n-2]);


        for(int i = n-3; i >=1 ; i--) {
            dp[i] = Math.max(dp[i+1],dp[i+2]+nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;

    }
}
