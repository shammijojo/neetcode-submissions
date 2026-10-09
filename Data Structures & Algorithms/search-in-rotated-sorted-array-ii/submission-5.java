class Solution {
    public boolean search(int[] nums, int target) {
        int right = findPivot(nums,target);
        int index = search(nums,target,0,right-1);
        if(index == -1) index = search(nums,target,right,nums.length-1);
        return index != -1;
    }

    private int findPivot(int[] nums, int target) {
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
            }
            else if(nums[mid] < nums[right]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
                left = mid+1;
            }else if(nums[mid] == nums[left]) {
                left++;
            } else if(nums[mid] == nums[right]) {
                right--;
            }
            mid = (left+right)/2;
        }

        return right;
        
    }

    private int search(int[] nums, int target, int left, int right) {
        int mid = (left+right)/2;

        while(left <= right) {
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            mid = (left+right)/2;
        }

        return -1;
    }
}