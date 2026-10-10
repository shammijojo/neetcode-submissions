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

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            nums[x-1] = Math.abs(nums[x-1])*-1;
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > 0){
                return i+1;
            }
        }

        return nums.length+1;
    }
}