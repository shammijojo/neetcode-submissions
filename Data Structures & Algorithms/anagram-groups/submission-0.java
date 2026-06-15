class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>, List<String>> anagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        

        for(String element : strs) {
            Map<Character,Integer> countByCharacters = new HashMap<>();
            for(int i = 0; i < element.length(); i++) {
                char c = element.charAt(i);
                if(countByCharacters.containsKey(c)) {
                    countByCharacters.put(c, countByCharacters.get(c)+1);
                } else {
                    countByCharacters.put(c, 1);
                }
            }

            if(anagrams.containsKey(countByCharacters)) {
                anagrams.get(countByCharacters).add(element);
            } else {
                anagrams.put(countByCharacters, new ArrayList<>(Arrays.asList(element)));
            }
        }


        return new ArrayList<List<String>>(anagrams.values());



    }
}
