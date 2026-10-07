class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while(right < s.length()) {
            char c = s.charAt(right);

            if(set.contains(c)) {
                char x = s.charAt(left);
                while(x != c) {
                    set.remove(x);
                    left++;
                    x = s.charAt(left);
                }
                left++;
            }

            set.add(c);
            int window = right-left+1;
            max = Math.max(max,window);
            right++;
        } 

        return max;
    }
}
