class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(check(word,"",i,j,m,n,board,visited)) return true;
            }
        }

        return false;
        
    }



    private boolean check(String word, String currentWord, int row, int col, int m, int n, 
    char[][] board, boolean[][] visited) {
        if(m <= row || n <= col || row < 0 || col < 0 || visited[row][col]) {
            return false;
        }

        currentWord = currentWord+board[row][col];
        if(currentWord.length() == word.length() && currentWord.equals(word)) {
            return true;
        }

        String substr = word.substring(0,currentWord.length());
        if(!substr.equals(currentWord)) {
            return false;
        }

        visited[row][col] = true;

        //go down
        boolean down = check(word,currentWord,row+1,col,m,n,board,visited);

        //go up
        boolean up = check(word,currentWord,row-1,col,m,n,board,visited);

        //go right
        boolean right = check(word,currentWord,row,col+1,m,n,board,visited);

        //go left
        boolean left = check(word,currentWord,row,col-1,m,n,board,visited);

        visited[row][col] = false;


        //System.out.println(down+" "+up+" "+left+" "+right);
        return down || up || left || right;

    }



}
