class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexByValue = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(indexByValue.containsKey(target-nums[i])) {
                return new int[]{indexByValue.get(target-nums[i]),i};
            }
            if(!indexByValue.containsKey(nums[i])) {
                indexByValue.put(nums[i],i);
            }
        }

        return new int[]{};
    }
}
