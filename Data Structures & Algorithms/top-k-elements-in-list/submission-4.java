class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((Map.Entry<Integer, Integer> a, Map.Entry<Integer,Integer> b) -> a.getValue()-b.getValue());
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
        
    }
}
