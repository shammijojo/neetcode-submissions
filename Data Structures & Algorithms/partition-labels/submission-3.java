class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,i);
        }

        int l = 0, r = 0;

        while(l < s.length()) {
            char c = s.charAt(l);
            r = map.get(c);

            for(int i = l; i <= r; i++) {
                r = Math.max(r,map.get(s.charAt(i)));
            }
            result.add(r-l+1);
            l=r+1;
        }

        return result;
    }
}
