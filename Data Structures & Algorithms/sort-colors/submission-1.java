class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(mid <= right) {
            if(nums[mid] == 0) {
                swap(nums,left,mid);
                mid++;
                left++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums,right,mid);
                right--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}