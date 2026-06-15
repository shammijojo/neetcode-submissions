class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(board, word, 0,board.length,board[0].length,i,j, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int pos,
    int m, int n, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || pos >= word.length()) {
            return false;
        }

        if(board[row][col] != word.charAt(pos)) {
            return false;
        }
        if(pos == word.length()-1) return true;

        visited[row][col] = true;

        
        boolean a = backtrack(board, word, pos+1, m, n, row+1, col, visited);
        if(a) return true;
        boolean b = backtrack(board, word, pos+1, m, n, row-1, col, visited);
        if(b) return true;
        boolean x = backtrack(board, word, pos+1, m, n, row, col+1, visited);
        if(x) return true;
        boolean d = backtrack(board, word, pos+1, m, n, row, col-1, visited);
        if(d) return true;

        visited[row][col] = false;
        return false;
    }
}
