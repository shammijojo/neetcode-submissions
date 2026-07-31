class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0 , r = 0;
        int max = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            if(set.contains(c)) {
                while(s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }

            set.add(c);
            max = Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
}
