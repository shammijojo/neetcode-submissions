class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                //visited = new boolean[board.length][board[0].length];
                if(search(board,i,j,board.length,board[0].length,word,"",visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean search(char[][] board, int row, int col, int m, int n, String word,
    String currentWord, boolean[][] visited) {
        // System.out.println(currentWord);
        if(currentWord.equals(word)) {
            return true;
        }

         if(row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        if(!word.startsWith(currentWord) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        boolean b =  search(board,row+1,col,m,n,word,currentWord+board[row][col], visited) ||
        search(board,row-1,col,m,n,word,currentWord+board[row][col], visited) ||
        search(board,row,col+1,m,n,word,currentWord+board[row][col], visited) ||
        search(board,row,col-1,m,n,word,currentWord+board[row][col], visited);

        visited[row][col] = false;
        return b;



    }

}
