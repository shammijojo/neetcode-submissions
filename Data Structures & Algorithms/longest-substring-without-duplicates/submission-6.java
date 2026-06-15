class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;

        Map<Character,Integer> indexByCharacter = new HashMap<>();

        int start = 0, end = 0;
        int max = 1;

        while(end < s.length()) {
            char c = s.charAt(end);
            if(indexByCharacter.containsKey(c) && indexByCharacter.get(c) >= start)
            start = indexByCharacter.get(c)+1;
           
            max = Math.max(max,end-start+1);
            indexByCharacter.put(c,end);
            end++;
        }

        return max;
    }
}
