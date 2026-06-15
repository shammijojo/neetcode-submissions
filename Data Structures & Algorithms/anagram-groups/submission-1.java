class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character,Integer>,List<String>> anagrams = new HashMap<>();


        for(String str : strs) {
            Map<Character,Integer> frequencyByCharacter = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                frequencyByCharacter.put(c,frequencyByCharacter.getOrDefault(c,0)+1);
            }

            if(anagrams.containsKey(frequencyByCharacter)) {
                anagrams.get(frequencyByCharacter).add(str);
            } else {
                anagrams.put(frequencyByCharacter,new ArrayList<>(List.of(str)));
            }
        }

        anagrams.values().forEach(result::add);

        return result;


    }
}
