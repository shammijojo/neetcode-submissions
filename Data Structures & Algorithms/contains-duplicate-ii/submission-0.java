class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                for(int index : map.get(nums[i])) {
                    if(Math.abs(index-i) <= k) {
                        return true;
                    }
                }
            } else {
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        return false;
    }
}