class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);

        System.out.println(pivot);
        boolean b = binarySearch(nums,0,pivot-1,target);
        if(b) return true;

        return binarySearch(nums,pivot,nums.length-1,target);
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while(left < right) {
            if(nums[left] == nums[right]) {
                if(nums[left+1] >= nums[left]) {
                    left++;
                } else {
                    right--;
                }
            } else if(nums[right] == nums[mid]) {
                right--;
            } else if(nums[left] == nums[mid]) {
                left++;
            } else if(nums[right] > nums[mid]) {
                right = mid;
            } else if(nums[right] < nums[mid]) {
                left = mid+1;
            }
            mid = (left+right)/2;
        }

        return left;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left+right)/2;

        while(left <= right) {
            if(nums[mid] < target) {
                left = mid+1;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                return true;
            }
            mid = (left+right)/2;
        }

        return false;
    }


}