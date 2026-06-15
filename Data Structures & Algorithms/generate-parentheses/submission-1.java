class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0,0,n,"",result);
        return result;
    }


    private void generate(int closed,int open,int n,String str,
    List<String> result) {
        if(closed == n) {
            result.add(new String(str));
            return;
        }

        if(open<n) {
            generate(closed,open+1,n,str+"(",result);
        }

        if(closed<open) {
            generate(closed+1,open,n,str+")",result);
        }

        
    }
}
