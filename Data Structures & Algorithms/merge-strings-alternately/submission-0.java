class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;
        boolean b = false;
        StringBuilder sbr = new StringBuilder();

        while(i < len1 && j < len2) {
            if(!b) {
                sbr.append(word1.charAt(i++));
            } else {
                sbr.append(word2.charAt(j++));
            }
            b = !b;
        }

        if(i < len1) {
            sbr.append(word1.substring(i));
        }

        if(j < len2) {
            sbr.append(word2.substring(j));
        }

        return sbr.toString();

    }
}