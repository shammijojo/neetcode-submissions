class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0;

        while(end < s.length()) {
            char c = s.charAt(end);
            int count = map.getOrDefault(c,0);
            map.put(c,count+1);
            
            if(count > 0) {
                char x = s.charAt(start);
                while(x != c) {
                    map.put(x,map.get(x)-1);
                    start++;
                    x = s.charAt(start);
                }
                start++;
                map.put(x,map.get(x)-1);
            } else {
                System.out.println(end+" "+start);
                maxLength = Math.max(maxLength,end-start+1);
            }
            end++;
           
        }

        return maxLength;


    }
}
