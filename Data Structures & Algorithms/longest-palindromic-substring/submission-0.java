class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";


        for(int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if( max < r-l+1) {
                    max = r-l+1;
                    result = s.substring(l,r+1);
                }
                
                l--;
                r++;
            }
        }


          for(int i = 0; i < s.length(); i++) {
            int l = i, r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if( max < r-l+1) {
                    max = r-l+1;
                    result = s.substring(l,r+1);
                }
                
                l--;
                r++;
            }
        }



        return result;
    }
}
