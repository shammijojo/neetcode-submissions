class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int max = 0;
        int minPrice = prices[0];
        dp[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp[i] = minPrice;
            minPrice = Math.min(minPrice,prices[i]);
            max = Math.max(max,prices[i]-dp[i]);
        }

        return max;

    }
}
