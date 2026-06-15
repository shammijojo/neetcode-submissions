class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> elementByIndex = new HashMap<>();

        int index = -1;
        for(int num : nums) {
            index++;
            if(elementByIndex.containsKey(target-num)) {
                return new int[]{elementByIndex.get(target-num),index};
            } else {
                if(!elementByIndex.containsKey(num)) {
                    elementByIndex.put(num,index);
                }
            }
        }

        return new int[]{};
    }
}
