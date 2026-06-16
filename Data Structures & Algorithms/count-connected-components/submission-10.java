class Solution {
    public int countComponents(int n, int[][] edges) {


        int[][] adj = new int[n][n];

        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
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

    private void dfs(int v, int n, int[][] adj, boolean[] visited,
    boolean[] covered) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;

        for(int i = 0; i < n ; i++) {
            if(i == v) continue;
            if(adj[v][i] == 1 && !visited[i]) {
                dfs(i,n,adj,visited,covered);
            }
        }

        covered[v] = true;

    }
}
