class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 1; i <=amount; i++) {
            for(int coin : coins) {
                if(i-coin>=0) {
                    if(dp[i-coin]!=amount+1) {
                        if(dp[i]==amount+1)
                        dp[i] = dp[i-coin]+1;
                        else
                        dp[i] = Math.min(dp[i],dp[i-coin]+1);
                    }
                }
            }
        }

        return dp[amount]==amount+1?-1:dp[amount];

    }
}
