class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int maxCharFrequency = 0;
        int start = 0, end = 0;

        while(end < s.length()) {
            char c = s.charAt(end);
            int count = map.getOrDefault(c, 0);
            map.put(c,count+1);
            maxCharFrequency = Math.max(maxCharFrequency, count+1);

            while(end-start+1-maxCharFrequency > k) {
                c = s.charAt(start);
                count = map.get(c);
                map.put(c,count-1);
                start++;
            }

            max = Math.max(max,end-start+1);
            end++;
            
        }

        return max;

    }
}
