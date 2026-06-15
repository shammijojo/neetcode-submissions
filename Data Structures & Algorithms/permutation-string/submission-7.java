class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(!map1.containsKey(c)) {
                continue;
            }

            map2.clear();
            int index = i;
            while(index < s2.length() && map1.containsKey(s2.charAt(index))) {
                c = s2.charAt(index);
                map2.put(c,map2.getOrDefault(c,0)+1);
                if(map1.equals(map2)) {
                  return true;
                } else if(map2.get(c) > map1.get(c)) {
                    break;
                }


                index++;
            }
        }

        return false;
    }
}
