class Solution {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int index = binarySearch(0,pivot,target,nums);
        if(index != -1) return index;
        else
        return binarySearch(pivot,nums.length-1,target,nums);
    }

    private int binarySearch(int left, int right, int target, int nums[]) {
        int mid = (left+right)/2;

        while(left <= right) {
            if(nums[mid] < target) {
                left = mid+1;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                return mid;
            }
            mid = (left+right)/2;
        }
        return -1;
    }

    private int getPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while(left < right) {
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            }
            mid = (left+right)/2;
        }

        return left;
    }
}
