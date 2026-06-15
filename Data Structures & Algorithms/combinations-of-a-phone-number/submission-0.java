class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        generateCombinations(result,new String(),digits,0);
        return result;
    }

    private void generateCombinations(List<String> result, String str,
    String digits, int index) {

        if(index == digits.length()) {
            if(str.length() > 0) {
                result.add(new String(str));
            }
            return;
        }

        String s = getChars(digits.charAt(index));
        for(int i = 0; i < s.length(); i++) {
            generateCombinations(result, str+s.charAt(i),digits, index+1);
        }

        
        
    }

    private String getChars(char digit) {
        switch(digit) {
            case '2':
            return "abc";
            case '3':
            return "def";
            case '4':
            return "ghi";
            case '5':
            return "jkl";
            case '6':
            return "mno";
            case '7':
            return "pqrs";
            case '8':
            return "tuv";
            case '9':
            return "wxyz";
            default:
            return "";
        }
    }


}
