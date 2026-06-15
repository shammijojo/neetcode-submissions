class PrefixTree {

    class TrieNode {
        Map<Character,TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trieNode = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(trieNode.children.containsKey(c)) {
                trieNode = trieNode.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                trieNode.children.put(c,newNode);
                trieNode = newNode;
            }
        }
        trieNode.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode trieNode = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(trieNode.children.containsKey(c)) {
                trieNode = trieNode.children.get(c);
            } else {
                return false;
            }
        }
        return trieNode.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(trieNode.children.containsKey(c)) {
                trieNode = trieNode.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
