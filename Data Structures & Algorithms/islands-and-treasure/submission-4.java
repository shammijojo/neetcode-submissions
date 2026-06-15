class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                        queue.add(new int[]{i+1,j});
                        queue.add(new int[]{i,j+1});
                        queue.add(new int[]{i-1,j});
                        queue.add(new int[]{i,j-1});
                    //System.out.println(queue.size());
                    //queue.add(new int[]{i,j});
                }
            }
        }

        bfs(queue,visited,1,grid);
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int value,
    int[][] grid) {
        if(queue.isEmpty()) {
            return;
        }

        int size = queue.size();
        for(int i = 0; i < size; i++) {
            int[] x = queue.poll();
            int r = x[0];
            int c = x[1];

            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            continue;
            }

            if(grid[r][c] == -1 || grid[r][c] == 0) {
                continue;
            }

            if(visited[r][c]) {
                continue;
            } 

            visited[r][c] = true;
           // if(grid[r][c] == 2147483647)
            grid[r][c] = value;

            queue.add(new int[]{r+1,c});
            queue.add(new int[]{r,c+1});
            queue.add(new int[]{r-1,c});
            queue.add(new int[]{r,c-1});

        }

        bfs(queue,visited,value+1,grid);
    }
}
