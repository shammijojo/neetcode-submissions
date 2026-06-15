class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            } else if(nums[i] == 0) {
                min = 1;
                max = 1;
            }

            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);

            maxProduct = Math.max(maxProduct,max);

        }

        return maxProduct;
    }
}
