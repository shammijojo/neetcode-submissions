class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int left = 0;
        int right = 0;

        while(left < s.length()) {
            for(int i = left; i <= right; i++) {
                char c = s.charAt(i);
                int index = map.get(c);
                right = Math.max(right,index);
            }

            int window = right-left+1;
            result.add(window);
            left = right+1;
            right = left;
            
        }

        return result;
    }
}
