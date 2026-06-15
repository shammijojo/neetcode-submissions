class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }

        bfs(grid,queue,visited,m,n,0);
    }

    private void bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited,
    int m, int n, int distance) {
        
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            int[] x = queue.poll();
            int row = x[0];
            int col = x[1];

            grid[row][col] = distance;
            addToQueue(grid,queue,m,n,row+1,col,visited);
            addToQueue(grid,queue,m,n,row-1,col,visited);
            addToQueue(grid,queue,m,n,row,col+1,visited);
            addToQueue(grid,queue,m,n,row,col-1,visited);
        }

        if(!queue.isEmpty())
        bfs(grid,queue,visited,m,n,distance+1);

    }

    private void addToQueue(int[][] grid, Queue<int[]> queue, int m, int n, int row, int col,
    boolean visited[][]) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }

        if(grid[row][col] == 2147483647) {
            queue.add(new int[]{row,col});
            visited[row][col] = true;
        }
        
    }
}
