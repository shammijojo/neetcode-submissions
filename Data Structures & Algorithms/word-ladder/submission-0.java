class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.add(beginWord);
        set.remove(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    System.out.println(word);
                    return level;
                }

                for(int j = 0; j < word.length(); j++) {
                    StringBuilder sb = new StringBuilder(word);
                    for(char c = 'a'; c <='z'; c++) {
                        sb.setCharAt(j,c);
                        if(set.contains(sb.toString())) {
                        queue.add(sb.toString());
                        set.remove(sb.toString());
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
