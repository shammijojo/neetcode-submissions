class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for(char c : s1.toCharArray()) {
            s1Map.put(c,s1Map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Map.put(c,s2Map.getOrDefault(c,0)+1);
        }

        if(s1Map.equals(s2Map)) {
            return true;
        }

        int r = 0;
        for(int i = s1.length(); i < s2.length(); i++) {
            char c = s2.charAt(i);
            s2Map.put(c,s2Map.getOrDefault(c,0)+1);

            c = s2.charAt(r);
            r++;
            s2Map.put(c,s2Map.getOrDefault(c,0)-1);

            if(s2Map.get(c) == 0) s2Map.remove(c);

            if(s1Map.equals(s2Map)) {
            return true;
            }
        }

        return false;
    }
}
