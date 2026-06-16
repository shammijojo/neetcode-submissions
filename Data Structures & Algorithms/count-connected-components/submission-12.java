class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] covered = new boolean[n];
        boolean[] visited = new boolean[n];

        int count = 0;
        for(int i = 0 ;i < n; i++) {
            if(!covered[i]) {
                dfs(i,n,adj,visited,covered);
                count++;
            }
        }

        return count;



    }

    private void dfs(int v, int n,List<List<Integer>>  adj, boolean[] visited,
    boolean[] covered) {
        
        visited[v] = true;

        for(int i = 0; i < adj.get(v).size() ; i++) {
            int x = adj.get(v).get(i);
            if(!visited[x]) {
                dfs(x,n,adj,visited,covered);
            }
        }

        covered[v] = true;

    }
}
