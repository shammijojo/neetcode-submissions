class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        List<Integer> result = new ArrayList<>();
        boolean[] completed = new boolean[numCourses];
        for(int i = 0 ; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
                if(!completed[i]) {
                    if(!dfs(adj,visited,i,numCourses,result,completed)) {
                    return new int[]{};
                }
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(int[][] prerequisites, boolean[] visited,
    int course, int n, List<Integer> result, boolean[] completed) {
        if(visited[course]) {
            return false;
        }

        visited[course] = true;

        for(int i = 0; i < n ; i++) {
            if(prerequisites[course][i] == 1) {
                if(!dfs(prerequisites,visited,i,n,result,completed)) {
                    return false;
                }
            }
        }

        if(!result.contains(course))
        result.add(course);

        completed[course] = true;
        visited[course] = false;

        return true;
    }
}
