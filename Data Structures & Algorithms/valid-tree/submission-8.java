class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return true;
        if(n == 1) return false;

        int[][] adj = new int[n][n];

        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }

        boolean[] covered = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean b = dfs(adj,visited,0,n,covered);
        if(!b) return false;

        for(int i = 0 ; i < n; i++) {
            if(!covered[i]) {
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int[][] prerequisites, boolean[] visited,
    int course, int n, boolean[] covered) {
        if(covered[course]) {
            return false;
        }

        if(visited[course]) {
            return true;
        }

        visited[course] = true;

        for(int i = 0; i < n ; i++) {
            //if(i == course) continue;
            if(prerequisites[course][i] == 1) {
                if(!dfs(prerequisites,visited,i,n,covered)) {
                    return false;
                }
            }
        }

        covered[course] = true;
        visited[course] = false;

        return true;
    }
}
