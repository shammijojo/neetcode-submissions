class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(dfs(grid,i,j,m,n),max);
                }
            }
        }

        
        return max;
    }


    private int dfs(int[][] grid, int row, int col, int m, int n) {
        if(row >= m || row < 0 || col >= n || col < 0 || 
        grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = 2;

        return dfs(grid,row+1,col,m,n)+
        dfs(grid,row-1,col,m,n)+
        dfs(grid,row,col+1,m,n)+
        dfs(grid,row,col-1,m,n)+1;
    }
}
