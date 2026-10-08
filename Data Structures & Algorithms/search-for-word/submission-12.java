class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(exist(m,n,i,j,board,visited,word,0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean exist(int m, int n, int row, int col, char[][] board, boolean[][] visited,
    String word, int index) {
        if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) {
            return false;
        }

        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        if(index == word.length()-1) {
            return true;
        }

        boolean a = exist(m,n,row+1, col, board, visited,word, index+1);
        if(a) return true;
        boolean b = exist(m,n,row-1, col, board, visited,word, index+1);
        if(b) return true;
        boolean c = exist(m,n,row, col+1, board, visited,word, index+1);
        if(c) return true;
        boolean d = exist(m,n,row, col-1, board, visited,word, index+1);
        if(d) return true;

        visited[row][col] = false;
        return false;

    }
}
