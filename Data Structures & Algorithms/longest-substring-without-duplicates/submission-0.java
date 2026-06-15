class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character,Integer> indexByCharacter = new HashMap<>();
        int start = 0, end = 0;

        while(end < s.length()) {
            char c = s.charAt(end);
            if(indexByCharacter.containsKey(c) && indexByCharacter.get(c)>=start) {
                start = indexByCharacter.get(c)+1;
            } else {
                maxLength = Math.max(maxLength, end-start+1);
                indexByCharacter.put(c,end);
                end++;
            }
        }

        return maxLength;


    }
}
