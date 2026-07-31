class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        words.addAll(wordList);

        System.out.println(words);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            for(int j = 0; j < size; j++) {
                StringBuilder currentWord = new StringBuilder(queue.poll());
                System.out.println(currentWord);
                if(currentWord.toString().equals(endWord)) {
                    return steps;
                }
                for(int i = 0; i < currentWord.length(); i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        StringBuilder tempWord = new StringBuilder(currentWord);
                        tempWord.setCharAt(i,c);
                       //System.out.println(tempWord);
                        if(words.contains(tempWord.toString())) {
                            queue.add(tempWord.toString());
                            words.remove(tempWord.toString());
                        }
                    }
                }
            }

            steps++;
            
        }

        return 0;
    }
}
