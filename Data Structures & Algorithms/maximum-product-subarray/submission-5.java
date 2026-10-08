class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int max = nums[0];


        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(maxProduct*nums[i],nums[i]);
            minProduct = Math.min(minProduct*nums[i],nums[i]);
            max = Math.max(max,maxProduct);
        }

        return max;
    }
}
