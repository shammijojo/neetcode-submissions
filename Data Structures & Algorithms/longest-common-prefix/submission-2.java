class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String result = "";

        for(int i = 0; i < strs[0].length(); i++) {
            String str = strs[0].substring(0,i+1);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() < str.length() || !strs[j].startsWith(str)) {
                    return result;
                }
            }
            result = str;
        }

        return result;
    }
}