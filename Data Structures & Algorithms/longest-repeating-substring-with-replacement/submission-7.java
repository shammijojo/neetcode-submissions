class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int max = 0;
        int maxf = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            int windowSize = i-l+1;
            maxf = Math.max(maxf,map.get(c));

            while(windowSize-maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
                windowSize = i-l+1;
            }
            max = Math.max(max,windowSize);
        }

        return max;
    }
}
