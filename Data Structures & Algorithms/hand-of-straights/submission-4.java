class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x : hand) {
            pq.add(x);
            map.put(x,map.getOrDefault(x,0)+1);
        }

        if(hand.length%groupSize != 0) {
            return false;
        }
        
        int groups = 0;

        while(groups < hand.length/groupSize) {
            while(!pq.isEmpty() && map.get(pq.peek()) == 0) {
                pq.poll();
            }
            if(pq.isEmpty()) return false;
            int x = pq.poll();
            for(int i = 0; i < groupSize; i++) {
                if(!map.containsKey(x)) return false;
                int count = map.get(x);
                if(count == 0) {
                    return false;
                }
                map.put(x,count-1);
                x++;
            }
            groups++;
        }

        return groups == hand.length/groupSize;


    }
}
