class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid,visited,m,n,i,j);
                    max = Math.max(area,max);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int m, int n,
    int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]
        || grid[row][col] == 0) {
            return 0;
        }


        visited[row][col] = true;


        return
        dfs(grid, visited, m,n, row+1, col)+
        dfs(grid, visited, m,n, row-1, col)+
        dfs(grid, visited, m,n, row, col+1)+
        dfs(grid, visited, m,n, row, col-1)+
        1;

    }
}
