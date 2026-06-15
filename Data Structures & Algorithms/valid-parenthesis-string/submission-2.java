class Solution {
    public boolean checkValidString(String s) {
        int openBrackenMin = 0;
        int openBrackenMax = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                openBrackenMin++;
                openBrackenMax++;
            } else if(c == ')') {
                openBrackenMin--;
                openBrackenMax--;
            } else {
                openBrackenMin--;
                openBrackenMax++;
            }

            if(openBrackenMax < 0) {
                return false;
            }   

            openBrackenMin = Math.max(0,openBrackenMin);
        }


        System.out.println(openBrackenMin);
        if(openBrackenMin > 0) {
            return false;
        }

        return true;
    }
}
