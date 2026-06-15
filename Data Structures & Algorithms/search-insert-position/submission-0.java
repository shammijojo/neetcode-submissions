class Solution {
    public int searchInsert(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;

        if(target > arr[right]) {
            return right+1;
        }

        int index = right;
        while(left < right) {
            if(arr[mid] > target) {
                right = mid;
            } else if(arr[mid] < target) {
                left = mid+1;
            } else if(arr[mid] == target) {
                return mid;
            }

            System.out.println(left+" "+right);
            mid = (left+right)/2;
        } 

        return right;
    }
}