class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for(int num : nums) {
            if(elements.contains(num)) {
                return true;
            }
            elements.add(num);
        }

        return false;
    }
}
