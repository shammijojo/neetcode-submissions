class Solution {
    public String longestPalindrome(String s) {

        String result = "";
        int max = 0;

        //For even length
        for(int i = 0; i < s.length()-1; i++) {
            int left = i;
            int right = i+1;

            while(left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
                    int window = right-left+1;
                    if(window > max) {
                        max = window;
                        result = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
        }

        //For odd length
        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
                    int window = right-left+1;
                    if(window > max) {
                        max = window;
                        result = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
        }

        return result;

        
    }
}
