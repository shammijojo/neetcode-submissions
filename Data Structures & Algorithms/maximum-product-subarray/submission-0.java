class Solution {
    public int maxProduct(int[] arr) {
        int min = 1, max = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                min = 1;
                max = 1;
            } else if(arr[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(arr[i], arr[i]*max);
            min = Math.min(arr[i], arr[i]*min);
            maxProduct = Math.max(maxProduct, max);
        }

        return maxProduct;
    }
}
