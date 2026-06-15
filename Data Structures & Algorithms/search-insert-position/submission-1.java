class Solution {
    public int searchInsert(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;

        if(target > arr[right]) {
            return right+1;
        }

        while(left < right) {
            if(arr[mid] > target) {
                right = mid;
            } else if(arr[mid] < target) {
                left = mid+1;
            } else if(arr[mid] == target) {
                return mid;
            }
            mid = (left+right)/2;
        } 

        return right;
    }
}