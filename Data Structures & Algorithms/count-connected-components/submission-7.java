class Solution {
    public int countComponents(int n, int[][] edges) {
        int[][] adj = new int[n][n];

        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }


        boolean[] covered = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if(!covered[i]) {
                dfs(adj,visited,i,n,covered);
                count++;
            }
            
            boolean allCovered = true;
            for(int j = 0; j < n; j++) {
                if(!covered[j]) allCovered = false;
            }

            if(allCovered) {
                return count;
            }
        }

        return count;



    }


    private void dfs(int[][] prerequisites, boolean[] visited,
    int course, int n, boolean[] covered) {
        if(covered[course] || visited[course]) {
            return;
        }

        visited[course] = true;

        for(int i = 0; i < n ; i++) {
            if(i == course) continue;
            if(prerequisites[course][i] == 1) {
                dfs(prerequisites,visited,i,n,covered);
            }
        }

        covered[course] = true;
        visited[course] = false;
    }
}
