class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];


        for(int i = 0 ; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            int fromParent = getParent(from,parent);
            int toParent = getParent(to,parent);

            if(fromParent == toParent) {
                return new int[]{from,to};
            }

            parent[fromParent] = toParent;
        }

        return new int[]{};
    }

    private int getParent(int edge, int[] parent) {
        if(parent[edge] == 0) {
            return edge;
        }

        return getParent(parent[edge],parent);
    }
}
