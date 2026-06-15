class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x:nums) {
            sum += x;
        }  

        if(sum %2 != 0) {
            return false;
        }

        return backtrack(nums,0,sum/2,0);
    }

    private boolean backtrack(int[] nums,int sum, int target, int index) {
        if(sum == target) {
            return true;
        }

        for(int i = index; i < nums.length; i++) {
            if(sum+nums[i] > target) continue;
            if(backtrack(nums,sum+nums[i],target,i+1)) {
                return true;
            }
        }

        return false;
    }
}
