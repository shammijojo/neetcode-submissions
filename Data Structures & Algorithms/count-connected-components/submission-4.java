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
            int[] status = new int[n];
            status[i] = 1;
            visited[i] = true;
            dfs(adj,status,i,visited);
            visits++;
        }
        
        return visits;
    }

    private void dfs(List<List<Integer>> adj, int[] status, int v, boolean[] visited) {
        List<Integer> list = adj.get(v);

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(status[x] == 0){
                status[x] = 1;
                visited[x] = true;
                dfs(adj,status,x,visited);
            }
        }
    }
}
