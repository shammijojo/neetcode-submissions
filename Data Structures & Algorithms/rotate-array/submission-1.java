class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length-1;
        k = k%(n+1);
        reverse(nums,0,n);
        reverse(nums,0,k-1);
        reverse(nums,k,n);
    }

    private void reverse(int arr[], int left, int right) {
        while(right > left) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }
    }
}