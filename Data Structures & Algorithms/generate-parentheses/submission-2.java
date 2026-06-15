class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }

    private void backtrack(List<String> result, String pairs, int open,
    int closed, int n) {
        if(closed == n) {
            result.add(pairs);
        }


        if(open < n) {
            backtrack(result, pairs+"(",open+1,closed,n);
        }

        if(closed < open) {
            backtrack(result,pairs+")",open,closed+1,n);
        }


    }

}
