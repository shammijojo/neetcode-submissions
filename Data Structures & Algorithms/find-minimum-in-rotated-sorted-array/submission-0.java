class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int mid = (low+high)/2;

        if(nums[low]<nums[high]) {
            return nums[low];
        }

        while(low < high) {
            if(nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
            mid = (low+high)/2;
        }

        return nums[low];
    }
}
