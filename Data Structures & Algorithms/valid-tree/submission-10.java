class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

         for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> traversed = new ArrayList<>();
        boolean[] visited = new boolean[n];
        if(!isPossible(n,adj,0,visited, traversed)) return false;

        return traversed.size() == n;
    }

     private boolean isPossible(int n, List<List<Integer>> adj, int v, boolean[] visited,
     List<Integer> traversed) {

        if(traversed.contains(v)) {
            return false;
        }

        if(visited[v]) return true;
        
        visited[v] = true;
        for(int i = 0; i < adj.get(v).size(); i++) {
            int x = adj.get(v).get(i);
            if(!isPossible(n,adj,x,visited, traversed)) {
                return false;
            }
        }


        traversed.add(v);
        visited[v] = false;

        return true;
    }
}
