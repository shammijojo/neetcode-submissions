class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyByElement = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            frequencyByElement.put(nums[i],frequencyByElement.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        List<Integer> result = new ArrayList<>();
        pq.addAll(frequencyByElement.entrySet());

        for(int i = 0;i < k; i++) {
            result.add(pq.poll().getKey());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
