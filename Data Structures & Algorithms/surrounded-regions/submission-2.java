class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m-1 || j==n-1) {
                    if(board[i][j] == 'O') {
                        dfs(board,i,j,m,n);
                       // System.out.println(i+" "+j);
                    }
                }
            }
        }

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n ;j++) {
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    private void dfs(char[][] board, int row, int col, int m, int n) {
        if(row >= m || col >= n || row < 0 || col < 0 ||
         board[row][col] != 'O') {
            return;
        }

        board[row][col] = '1';

        dfs(board,row+1,col,m,n);
        dfs(board,row-1,col,m,n);
        dfs(board,row,col+1,m,n);
        dfs(board,row,col-1,m,n);
    }
}
