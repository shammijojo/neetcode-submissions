class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        int count = 0;

        while(right > left) {
            if(s.charAt(right) == s.charAt(left)) {
                right--;
                left++;
            } else {
                if(count > 0) return false;
                count++;
                if(right == left+1) return true;
                
                if(s.charAt(right) == s.charAt(left+1)) {
                    left++;
                } else if(s.charAt(right-1) == s.charAt(left)) {
                    right--;
                }
                
            }
        }

        return true;
    }
}