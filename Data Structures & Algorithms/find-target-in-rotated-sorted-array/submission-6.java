class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int index = binarySearch(nums,target,pivot,nums.length-1);
        if(index != -1) return index;

        return binarySearch(nums,target,0,pivot-1);
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

        return right;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int left = start;
        int right = end;
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
}
