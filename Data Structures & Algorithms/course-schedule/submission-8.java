class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        for(int i = 0; i <numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            // System.out.println("calling");
            if(!dfs(i,adj,visited,numCourses)) {
                return false;
            }
        }

        return true;
    }


    private boolean dfs(int course, int[][] adj, boolean[] visited,int n) {

        // System.out.println(course+" "+visited[course]);
        if(visited[course]) {
            return false;
        }

        visited[course] = true;
        // System.out.println(course+" "+visited[course]);

        for(int i = 0; i < n; i++) {
            if(adj[course][i] == 1) {
                // System.out.println(course+" calling "+i);
                if(!dfs(i,adj,visited,n)) {
                    return false;
                }
            }
        }

        visited[course] = false;
        return true;
    }
}
