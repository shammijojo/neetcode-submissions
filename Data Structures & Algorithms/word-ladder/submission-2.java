class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int level = 1;

        queue.add(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();

                for(int j = 0; j < word.length(); j++) {
                    StringBuilder newWord = new StringBuilder(word);
                    for(char c = 'a'; c <= 'z'; c++) {
                        newWord.setCharAt(j,c);
                        if(set.contains(newWord.toString())) {
                            String newWordStr = newWord.toString();
                            queue.add(newWordStr);
                            set.remove(newWordStr);
                            if(endWord.equals(newWordStr)) {
                                return level+1;
                            }
                        }
                    }
                }
            }
            level++;
        }

        return 0;

    }
}
