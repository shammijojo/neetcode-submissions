class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        while(start <= end) {
            if(nums[start] == 0) {
                swap(nums,mid,start);
                mid++;
                start++;
            } else if(nums[start] == 1) {
                start++;
            } else {
                swap(nums,start,end);
                end--;
            }
        }
    }

    private void swap(int[] nums,int x, int y) {
        System.out.println(nums[x] +" "+nums[y]);
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        System.out.println(nums[x] +" "+nums[y]);
    }
}