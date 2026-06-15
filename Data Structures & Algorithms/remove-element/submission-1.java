class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        int count = 0;

        while(right >= left) {
            if(nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                count++;
            } else {
                left++;
            }
        }

        return nums.length-count;
    }
}