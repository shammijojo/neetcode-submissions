class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";

        //For odd-length
        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            int count= 0;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count = right-left+1;
                if(count > max) {
                    max = count;
                    result = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }


        //For even-length
        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i+1;
            int count = 0;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count = right-left+1;
                if(count > max) {
                    max = count;
                    result = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }

        return result;
    }
}
