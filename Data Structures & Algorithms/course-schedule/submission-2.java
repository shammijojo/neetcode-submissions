class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        for(int i = 0 ; i < numCourses; i++) {
            for(int j = 0 ; j < numCourses; j++)  {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }

        for(int i = 0 ; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            System.out.println("checking "+i);
            if(!dfs(adj,visited,i,numCourses)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] prerequisites, boolean[] visited,
    int course, int n) {
        System.out.println(".  "+course);
        if(visited[course]) {
            System.out.println(course);
            return false;
        }

        visited[course] = true;

        for(int i = 0; i < n ; i++) {
            if(prerequisites[course][i] == 1) {
                System.out.println("1 at "+course+" "+i);
                if(!dfs(prerequisites,visited,i,n)) {
                    return false;
                }
            }
        }

        visited[course] = false;

        return true;
    }
}
