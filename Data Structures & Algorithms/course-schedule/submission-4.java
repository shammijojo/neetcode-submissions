class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        boolean[] completed = new boolean[numCourses];
        for(int i = 0 ; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if(completed[i]) continue;
            if(!dfs(adj,visited,completed,i,numCourses)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] prerequisites, boolean[] visited, boolean[] completed,
    int course, int n) {
        if(visited[course]) {
            return false;
        }

        visited[course] = true;

        for(int i = 0; i < n ; i++) {
            if(prerequisites[course][i] == 1) {
                if(!dfs(prerequisites,visited,completed,i,n)) {
                    return false;
                }
            }
        }

        visited[course] = false;
        completed[course] = true;

        return true;
    }
}
