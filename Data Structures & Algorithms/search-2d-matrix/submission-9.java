class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = firstRowSmaller(matrix,target);
        return search(matrix,target,row);
    }

    private int firstRowSmaller(int[][] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        int row = 0;

        while(low<=high) {
            if(arr[mid][0] > target) {
                high = mid-1;
            } else if(arr[mid][0] < target) {
                row = mid;
                low = mid+1;
            } else {
                return mid;
            }
            mid = (low+high)/2;
        }

        return row;
    }


    private boolean search(int[][] nums, int target, int row) {
        int left = 0;
        int right = nums[0].length-1;
        int mid = (left+right)/2;

        while(left<=right) {
            if(nums[row][mid] > target) {
                right = mid-1;
            } else if(nums[row][mid] < target) {
                left = mid+1;
            } else {
                return true;
            }
            mid = (left+right)/2;
        }

        return false;

    }
}
