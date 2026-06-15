class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        int matches = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            smap.put(c, smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c)) {
                if(smap.get(c) == tmap.get(c)) {
                    matches++;
                }
            }

            while(l <=r && matches == tmap.size()) {
                if(matches == tmap.size()) {
                //System.out.println(l+" "+r);
                min = Math.min(min,r-l+1);
                result = s.substring(l,r+1);
            }
                c = s.charAt(l);
                int count = smap.get(c);
                if(tmap.containsKey(c)) {
                    if(count == tmap.get(c)) {
                        matches--;
                    }
                }
                smap.put(c,count-1);
               // System.out.println(l+"  "+r);
                l++;
            }
            r++;
        }

        return result;
    }
}
