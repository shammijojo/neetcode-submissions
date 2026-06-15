class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
             adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] covered = new boolean[n];
        for(int i = 0; i < n ; i++) {
            int[] status = new int[n];
            covered[i] = true;
            status[i] = 1;
            if(!dfs(i,adj,status,covered)) return false;
            for(int j = 0 ; j < n ; j++) {
            if(!covered[j]) return false;
         }
        }

        

        return true;
    }


    private boolean dfs(int n, List<List<Integer>> adj, int[] status, boolean[] covered) {
        if(status[n] == 2) {
            return false;
        }

        List<Integer> list = adj.get(n);
        for(int i = 0 ; i < list.size(); i++) {
            int x = list.get(i);
            if(status[x] == 1) {
                status[x] = 2;
            } else if(status[x] == 0){
                status[x] = 1;
                covered[x] = true;
                if(!(dfs(x,adj,Arrays.copyOf(status,status.length),covered))) return false;
             } else {
                return false;
             }
        }

        return true;
    }


}
