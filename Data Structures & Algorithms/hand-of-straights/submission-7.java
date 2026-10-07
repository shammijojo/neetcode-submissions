class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getKey()-b.getKey());

        if(hand.length%groupSize != 0) {
            return false;
        }

        for(int x : hand) {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        pq.addAll(map.entrySet());
       
        int groups = 0;

        while(groups < hand.length/groupSize) {
            int element = pq.peek().getKey();

            for(int i = 0; i < groupSize; i++) {
                if(!map.containsKey(element)) {
                    return false;
                }
                int f = map.get(element);
                if(f <= 0) {
                    return false;
                }

                map.put(element, map.get(element)-1);
                element++;
            }

            while(!pq.isEmpty() && map.get(pq.peek().getKey()) <= 0) {
                pq.poll();
            }

            groups++;
        }

        return true;
    }
}
