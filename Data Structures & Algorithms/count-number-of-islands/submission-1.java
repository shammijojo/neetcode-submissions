class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0 ;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid,visited,m,n,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int m, int n,
    int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]
        || grid[row][col] == '0') {
            return;
        }


        visited[row][col] = true;
        dfs(grid, visited, m,n, row+1, col);
        dfs(grid, visited, m,n, row-1, col);
        dfs(grid, visited, m,n, row, col+1);
        dfs(grid, visited, m,n, row, col-1);
    }
}
