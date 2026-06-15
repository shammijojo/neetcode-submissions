class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();

        int end = str.length()-1;
        for(int i = 0; i < end; i++) {
            char c = str.charAt(i);
            char endChar = str.charAt(end);
            if(isLetterOrDigit(c)) {
                while(!isLetterOrDigit(endChar)) {
                    end--;
                    endChar = str.charAt(end);  
                }
                if(c != str.charAt(end)) {
                    System.out.println(c+" "+str.charAt(end));
                    return false;
                } else {
                    end--;
                }
            }
        }

        return true;
    }

    private  boolean isLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= '0' && c <= '9');
}
}
