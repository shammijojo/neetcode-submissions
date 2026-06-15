class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for(char c : t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }

        int min = Integer.MAX_VALUE;
        String result = "";

        int l = 0;
        int matches = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sMap.put(c,sMap.getOrDefault(c,0)+1);

            if(sMap.get(c) == tMap.getOrDefault(c,0)) {
                matches++;
            }

            while(matches == tMap.size() && l <= r) {
                int size = r-l+1;
                if(size < min) {
                    min = size;
                    result = s.substring(l,r+1);
                }

                c = s.charAt(l);
                sMap.put(c,sMap.get(c)-1);
                if(tMap.containsKey(c) && sMap.get(c) < tMap.get(c)) {
                    matches--;
                }
                l++;
            }
            
        }

        return result;
    }
}
