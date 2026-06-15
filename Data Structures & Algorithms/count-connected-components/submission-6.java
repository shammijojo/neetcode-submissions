class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        int visits = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == true) continue;
            visited[i] = true;
            dfs(adj,i,visited);
            visits++;
        }
        
        return visits;
    }

    private void dfs(List<List<Integer>> adj, int v, boolean[] visited) {
        List<Integer> list = adj.get(v);

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(!visited[x]) {
                visited[x] = true;
                dfs(adj,x,visited);
            }
        }
    }
}
