class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        List<Integer> completed = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if(!isPossible(numCourses,adj,i,completed, visited)) {
                return new int[]{};
            }
        }

        if(completed.size() != numCourses) {
            return new int[]{};
        }



        return completed.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean isPossible(int n, List<List<Integer>> adj, int course, List<Integer> completed, boolean[] visited) {

        if(completed.contains(course)){
            return true;
        }

        if(visited[course]) {
            return false;
        }
        

        visited[course] = true;
        for(int i = 0; i < adj.get(course).size(); i++) {
            int x = adj.get(course).get(i);
            if(!isPossible(n,adj,x,completed,visited)) {
                return false;
            }
        }

        completed.add(course);

        return true;
    }
}
