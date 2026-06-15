class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;
        int currentProduct = nums[0];

        for(int i = 1; i < nums.length; i++) {
            product[i] = currentProduct;
            currentProduct *= nums[i]; 
        }

        int result[] = new int[nums.length];

        currentProduct = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            result[i] = product[i]*currentProduct;
            currentProduct *= nums[i]; 
        }

        return result;

    }
}  
