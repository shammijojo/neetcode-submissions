class WordDictionary {

    class TrieNode {
        Map<Character,TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
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

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println(c);
            if(c == '.') {
                if(node.children.size() == 0) return false;
                for(Map.Entry<Character,TrieNode> entry : node.children.entrySet()) {
                    if(dfs(word, i+1, entry.getValue())){
                        System.out.println("true "+c);
                        return true;
                    }
                }
                System.out.println("false "+c);
                return false;
            } else {
                if(node.children.containsKey(c)) {
                    return dfs(word,i+1,node.children.get(c));
                } else {
                    return false;
                }
            }
        }

        System.out.println("end "+node.endOfWord);
        return node.endOfWord;
        

    }
}
