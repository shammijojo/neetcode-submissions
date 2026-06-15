class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "",n , 0 , 0);
        return result;
    }

    private void generate(List<String> result, String str,
     int n, int open, int closed) {
        if(open == n && closed == n) {
            result.add(str);
            return;
        }

        if(open < n) {
            generate(result,str+"(", n, open+1,closed);
        }

        if(closed < open) {
            generate(result,str+")",n,  open,closed+1);
        }
    }
}
