class Solution {
    //If any loop found in graph, then not possible
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if(!dfs(i,numCourses,adj,visited,result)) {
                return new int[]{};
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    private boolean dfs(int course, int n, int[][] adj, boolean[] visited,
    List<Integer> result) {
        if(visited[course]) {
            return false;
        }

        visited[course] = true;

        for(int i = 0; i < n; i++) {
            if(adj[course][i] == 1) {
                if(!dfs(i,n,adj,visited,result)) {
                    return false;
                }
            }
        }

        visited[course] = false;

        if(!result.contains(course))
        result.add(course);

        return true;

    }
}
