class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;

        while(i < nums.length) {
            int x = nums[i];
            while(i < nums.length && nums[i] == x) {
                i++;
            }
            nums[index++] = x;
        }

        return index;
    }
}