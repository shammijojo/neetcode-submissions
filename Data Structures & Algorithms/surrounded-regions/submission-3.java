class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(!visited[i][j]) {
                        dfs(board,visited,m,n,i,j);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void dfs(char[][] board, boolean[][] visited, int m, int n,
    int row, int col) {
        if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        if(board[row][col] == 'X') {
            return;
        }

        board[row][col] = 'Y';
        dfs(board, visited, m, n , row+1, col);
        dfs(board, visited, m, n , row-1, col);
        dfs(board, visited, m, n , row, col+1);
        dfs(board, visited, m, n , row, col-1);

    }
}
