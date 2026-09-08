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
            // if (!completed[i]) {
                List<Integer> list = new ArrayList<>();
                dfs(numCourses, i, adj, visited, list);
                for (int x : list) {
                    completed[x] = true;
                }
                result.add(list);
                System.out.println(list);
            // }
        }

        List<Boolean> bools = new ArrayList<>();

        for (int k = 0; k < queries.length; k++) {
            int a = queries[k][0];
            int b = queries[k][1];

            List<Integer> list = result.get(a);

            for(int i = list.size()-2; i >=0; i--) {
                if(list.get(i) == b) {
                    bools.add(true);
                }
            }

            if(bools.size() <= k) bools.add(false);

            // for (int i = 0; i < result.size(); i++) {
            //     boolean aFound = false;
            //     boolean bFound = false;
            //     for (int j = result.get(i).size()-1; j >= 0; j--) {
            //         if (result.get(i).get(j) == a) {
            //             aFound = true;
            //         } else if (result.get(i).get(j) == b) {
            //             bFound = true;
            //             if (aFound) {
            //                 bools.add(true);
            //             }
            //             break;
            //         }
            //     }
            //     if(bFound && aFound) break;
            // }
            // if(bools.size() <= k) bools.add(false);
        }

        return bools;
    }

    private void dfs(int n, int course, int[][] adj, boolean[] visited, List<Integer> completed) {
        if (visited[course] || completed.contains(course)) {
            System.out.println(course+" already there");
            return;
        }

        System.out.println("course "+course);

        visited[course] = true;

        for (int i = 0; i < n; i++) {
            if (i == course) continue;
                
            if (adj[course][i] == 1) {
                System.out.println("calling "+i);
                dfs(n, i, adj, visited, completed);
                // break;
            }
        }

        visited[course] = false;

        // if (!completed.contains(course)) {
            completed.add(course);
        // }
    }
}