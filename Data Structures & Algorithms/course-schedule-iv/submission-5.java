class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean[] visited = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];

        int[][] adj = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            List<Integer> list = new ArrayList<>();
            dfs(numCourses, i, adj, visited, list);
            for (int x : list) {
                completed[x] = true;
            }
            result.add(list);
        }

        List<Boolean> bools = new ArrayList<>();

        for (int k = 0; k < queries.length; k++) {
            int a = queries[k][0];
            int b = queries[k][1];

            List<Integer> list = result.get(a);

            for (int i = list.size() - 2; i >= 0; i--) {
                if (list.get(i) == b) {
                    bools.add(true);
                }
            }

            if (bools.size() <= k)
                bools.add(false);
        }

        return bools;
    }

    private void dfs(int n, int course, int[][] adj, boolean[] visited, List<Integer> completed) {
        if (visited[course] || completed.contains(course)) {
            return;
        }

        visited[course] = true;

        for (int i = 0; i < n; i++) {
            if (i == course)
                continue;

            if (adj[course][i] == 1) {
                dfs(n, i, adj, visited, completed);
            }
        }

        visited[course] = false;

        completed.add(course);
    }
}