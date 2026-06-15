class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsList = Arrays.asList(words);
        buildTrie(words);

        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                String str = ""+board[i][j];
                if(root.children.containsKey(board[i][j]))
                search(board,i,j,m,n,root.children.get(board[i][j]),visited,str,result,wordsList);
            }
        }

        return result;
    }

    private void search(char[][] board, int row, int col, int m, int n,
    TrieNode node, boolean[][] visited, String currentString, List<String> result,
    List<String> words) {
       
       if(node.endOfWord && words.contains(currentString) && !result.contains(currentString)) {
         result.add(currentString);
       }

       if(node.children.size() == 0) return;

        visited[row][col] = true;

        Set<Character> set = new HashSet<>();
        for(Map.Entry<Character,TrieNode> entry : node.children.entrySet()) {
            set.add(entry.getKey());
        }

        if(isPositionValid(row+1, col,m,n) && set.contains(board[row+1][col]) && !visited[row+1][col]) {
            char c = board[row+1][col];
            search(board,row+1,col,m,n,node.children.get(c),visited,
            currentString+c,result,words);
        }

        if(isPositionValid(row-1, col,m,n) && set.contains(board[row-1][col]) && !visited[row-1][col]) {
            char c = board[row-1][col];
            search(board,row-1,col,m,n,node.children.get(c),visited,
            currentString+c,result,words);
        }

        if(isPositionValid(row, col+1,m,n) && set.contains(board[row][col+1]) && !visited[row][col+1]) {
            char c = board[row][col+1];
            search(board,row,col+1,m,n,node.children.get(c),visited,
            currentString+c,result,words);
        }

        if(isPositionValid(row, col-1,m,n) && !visited[row][col-1] && set.contains(board[row][col-1])) {
            char c = board[row][col-1];
            search(board,row,col-1,m,n,node.children.get(c),visited,
            currentString+c,result,words);
        }

        visited[row][col] = false;


    }

    private boolean isPositionValid(int row, int col, int m, int n) {
        return !(row < 0 || col < 0 || row >=m || col >=n);
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    private void buildTrie(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(c,newNode);
                node = newNode;
            }
        }
        node.endOfWord = true;
    }
}