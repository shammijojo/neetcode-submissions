class Solution {
    public int findMin(int[] nums) {
        return nums[findPivot(nums)];
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while(left < right) {
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }

            mid = (left+right)/2;
        }

        return mid;
    }
}
