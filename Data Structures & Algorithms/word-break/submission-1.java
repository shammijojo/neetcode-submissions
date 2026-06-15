class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if(s.substring(i).startsWith(word) && dp[i+word.length()]) {
                    dp[i] = dp[i+word.length()];
                }
            }
        }

        return dp[0];
    }
}
