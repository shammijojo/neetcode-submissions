class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Map.Entry<Character,Integer>> pq = 
        new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        pq.addAll(map.entrySet());

        if(pq.peek().getValue() > Math.ceil((double)s.length()/2)) return "";

        int index = 0;
        StringBuilder sb = new StringBuilder(s);
        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.setCharAt(index,entry.getKey());
                index += 2;
                if(index >= s.length()) index = 1;
            }
        }

        System.out.println(sb);
        return sb.toString();
    }
}