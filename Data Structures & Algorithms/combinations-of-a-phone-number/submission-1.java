class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        backtrack(result,"",0,digits);
        return result;
    }

    private void  backtrack(List<String> result, String combinations,
    int index, String digits) {
        if(combinations.length() == digits.length()) {
            result.add(combinations);
            return;
        }

        String s = getValue(digits.charAt(index));
        for(int i = 0; i < s.length(); i++) {
            backtrack(result,combinations+s.charAt(i),index+1,digits);
        }


    }


    private String getValue(char digit) {
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
        }

        return "";
    }


}
