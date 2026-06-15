class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        if(cost.length < 2) return 0;

        for(int i = 2; i <= cost.length; i++) {
            int a = cost[i-1]+dp[i-1];
            int b = cost[i-2]+dp[i-2];

            dp[i] = Math.min(a,b);
        }

        return dp[cost.length];
    }
}
