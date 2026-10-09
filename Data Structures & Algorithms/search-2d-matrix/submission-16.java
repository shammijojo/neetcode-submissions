class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix,target);
        return search(matrix,target,row);
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int mid = (left+right)/2;
        int row = 0;

        while(left <= right) {
            if(matrix[mid][0] == target) {
                return mid;
            } else if(matrix[mid][0] < target) {
                row = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
            mid = (right+left)/2;
        }

        return mid;
    }

    private boolean search(int[][] nums, int target, int row) {
        int left = 0;
        int right = nums[0].length-1;
        int mid = (left+right)/2;

        while(left <= right) {
            if(nums[row][mid] == target) {
                return true;
            } else if(nums[row][mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            mid = (left+right)/2;
        }

        return false;
    }
}
