class Solution {
    public int firstMissingPositive(int[] nums) {
       boolean isOnePresent = false;

       for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                isOnePresent = true;
                break;
            }
       }

       if(!isOnePresent) {
            return 1;
       }

        int n = nums.length;
       for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n+1;
            }
       }


        
        for(int i = 0; i < n; i++) {
            if(Math.abs(nums[i]) > n) continue;

            System.out.println(nums[i]);
            nums[Math.abs(nums[i])-1] = Math.abs(nums[Math.abs(nums[i])-1]) * -1;

        }

        for(int i = 0; i < n ; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }

        return n+1;


    }
}