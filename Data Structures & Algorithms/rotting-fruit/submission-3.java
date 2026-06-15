class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int mins = -1;
        while(!queue.isEmpty()) {
            bfs(grid,queue,m,n);
            mins++;
        }
        

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return mins;
    }

    private void bfs(int[][] grid, Queue<int[]> queue, int m, int n) {
        if(queue.isEmpty()) return;

        int size = queue.size();
        for(int i = 0;i < size; i++) {
            int[] x = queue.poll();
            int row = x[0];
            int col = x[1];

            addToQueue(grid,queue,m,n,row+1,col);
            addToQueue(grid,queue,m,n,row-1,col);
            addToQueue(grid,queue,m,n,row,col+1);
            addToQueue(grid,queue,m,n,row,col-1);
        }
    }

     private void addToQueue(int[][] grid, Queue<int[]> queue, int m, int n, int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if(grid[row][col] == 1) {
            grid[row][col] = 2;
            queue.add(new int[]{row,col});
        }
        
        
        
    }
}
