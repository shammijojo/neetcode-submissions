class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println(pivot);
        int index = search(nums,target,0,pivot-1);
        if(index != -1) return index;
        return search(nums,target,pivot,nums.length-1);
    }

    private int findPivot(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left < right) {
            int mid = (left+right)/2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    private int search(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                return mid; 
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }
}
