class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> frequencyByCharacter = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyByCharacter.put(c,frequencyByCharacter.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!frequencyByCharacter.containsKey(c)) {
                return false;
            }
            int count = frequencyByCharacter.get(c);
            if(count == 1) {
                frequencyByCharacter.remove(c);
            } else {
                frequencyByCharacter.put(c,count-1);
            }
        }
        return frequencyByCharacter.isEmpty();
    }




}
