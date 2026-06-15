class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        backtrack(result,digits,"",0);
        return result;


    }

    private void backtrack(List<String> result, String digits, String word,
    int index) {

        if(word.length() == digits.length()) {
            result.add(new String(word));
            return;
        }

        char c = digits.charAt(index);
        char[] chars = getChars(c);

        for(char x : chars) {
            backtrack(result, digits, word+x, index+1);
        }
    }

    private char[] getChars(char n) {
        switch(n) {
            case '2':
            return "abc".toCharArray();
            case '3':
            return "def".toCharArray();
            case '4':
            return "ghi".toCharArray();
            case '5':
            return "jkl".toCharArray();
            case '6':
            return "mno".toCharArray();
            case '7':
            return "pqrs".toCharArray();
            case '8':
            return "tuv".toCharArray();
            case '9':
            return "wxyz".toCharArray();
        }
        return "".toCharArray();
    }
}
