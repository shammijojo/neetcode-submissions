class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,0,0,result,"");
        return result;
    }

    private void generate(int n, int open, int closed, List<String> list, String str) {
        if(closed == n) {
            list.add(str);
        }

        if(open < n) {
            generate(n, open+1, closed, list, str+"(");
        }

        if(closed < open) {
            generate(n, open, closed+1, list, str+")");
        }
    }
}
