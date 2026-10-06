class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();

        for(String word : strs) {
            Map<Character, Integer> countByCharacter = new HashMap<>();
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                countByCharacter.put(c, countByCharacter.getOrDefault(c,0)+1);
            }

            if(anagrams.containsKey(countByCharacter)) {
                anagrams.get(countByCharacter).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                anagrams.put(countByCharacter,list);
            }
        }


        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Map<Character, Integer>, List<String>> entry : anagrams.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
