class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i = s.length()-1; i >=0; i--) {
            for(String word : wordDict) {
                if(s.substring(i).startsWith(word)) {
                    if(dp[i+word.length()]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}
