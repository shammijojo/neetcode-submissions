class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix,target);
        System.out.println(row);
        if(search(matrix[row],target) != -1) {
            return true;
        }
        return false;
    }

    private int findRow(int[][] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int row = 0;

        while(left <= right) {
            int mid = (left+right)/2;

            if(target > nums[mid][0]) {
                row = mid;
                left = mid+1;
            } else if(target < nums[mid][0]){
                right = mid-1;
            } else {
                return mid;
            }
        }

        return row;
    }

    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(nums[mid] > target) {
                right = mid-1;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
