class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j,m,n);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col, int m, int n) {
        if(row >= m || row < 0 || col >= n || col < 0 || 
        grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';

        dfs(grid,row+1,col,m,n);
        dfs(grid,row-1,col,m,n);
        dfs(grid,row,col+1,m,n);
        dfs(grid,row,col-1,m,n);
    }
}
