class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> s1map = new HashMap<>();
        Map<Character,Integer> s2map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1map.put(c, s1map.getOrDefault(c,0)+1);
        }

        int start = 0;
        int end = 0;
        while(end < s2.length()) {
            char c = s2.charAt(end);
            s2map.put(c, s2map.getOrDefault(c,0)+1);

            if(end >= s1.length()) {
                c = s2.charAt(start);
                s2map.put(c, s2map.get(c)-1);
                if(s2map.get(c) == 0) {
                    s2map.remove(c);
                }
                start++;
            }

            if(s1map.equals(s2map)) return true;
            end++;
        }

        return false;
    }
}
