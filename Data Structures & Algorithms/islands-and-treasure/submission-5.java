class Solution {
    private static int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        System.out.println(queue.size());

        int distance  = 1;
        while(!queue.isEmpty()) {
            bfs(grid,queue,distance,m,n);
            distance++;
        }

    }


    private void bfs(int[][] grid, Queue<int[]> queue, int distance,
    int m, int n) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            update(row+1, col, m, n,grid,distance, queue);
            update(row-1, col, m, n,grid,distance, queue);
            update(row, col+1, m, n,grid,distance, queue);
            update(row, col-1, m, n,grid,distance, queue);
        }
    }

    private void update(int row, int col, int m, int n, int[][] grid,
    int value, Queue<int[]> queue) {
        if(row >= m || col >=n || row < 0 || col < 0) {
            return;
        }

        if(grid[row][col] == INF) {
            grid[row][col] = value;
            queue.add(new int[]{row,col});
        }
    }
}
