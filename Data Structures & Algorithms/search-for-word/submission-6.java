class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(board, word, "",board.length,board[0].length,i,j, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, String currentWord,
    int m, int n, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return false;
        }

        char c = board[row][col];
        currentWord += c;
        if(currentWord.equals(word)) {
            return true;
        }

        if(!word.startsWith(currentWord)) {
            return false;
        }

        visited[row][col] = true;

        boolean b = 
        backtrack(board, word, currentWord, m, n, row+1, col, visited) || 
        backtrack(board, word, currentWord, m, n, row-1, col, visited) || 
        backtrack(board, word, currentWord, m, n, row, col+1, visited) || 
        backtrack(board, word, currentWord, m, n, row, col-1, visited);

        visited[row][col] = false;
        return b;
    }
}
