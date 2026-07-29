class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyByElement = new HashMap<>();
        for(int x : nums) {
            frequencyByElement.put(x, frequencyByElement.getOrDefault(x,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue()-a.getValue()
        );

        pq.addAll(frequencyByElement.entrySet());

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
