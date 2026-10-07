class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        if(s2.length() < s1.length()) return false;

        for(int i = 0 ; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c,0)+1);
        }

        if(map1.equals(map2)) {
            return true;
        }

        int left = 0;
        for(int i = s1.length(); i < s2.length(); i++) {
            char leftC = s2.charAt(left);
            map2.put(leftC, map2.get(leftC)-1);
            if(map2.get(leftC) == 0) {
                map2.remove(leftC);
            }
            left++;

            char rightC = s2.charAt(i);
            map2.put(rightC, map2.getOrDefault(rightC,0)+1);

            if(map1.equals(map2)) {
            return true;
            }
        }

        return false;
    }
}
