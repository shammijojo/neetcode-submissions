class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix,target);
        //System.out.println(row);
        return binarySearch(matrix,target,row);
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int row = 0;

        while(left <= right) {
            int mid = (left+right)/2;

            if(matrix[mid][0] < target) {
                row = mid;
                left = mid+1;
            } else if(matrix[mid][0] > target) {
                right = mid-1;
            } else {
                return mid;
            }
        }

        return row;
    }

    private boolean binarySearch(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length-1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(matrix[row][mid] < target) {
                left = mid+1;
            } else if(matrix[row][mid] > target) {
                right = mid-1;
            } else {
                return true;
            }
        }

        return false;

    }
}
