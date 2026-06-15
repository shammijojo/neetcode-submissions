class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum+=num;
        }

        if(sum%2 !=0) return false;
        return backtrack(nums,0,sum,sum/2);
    }

    private boolean backtrack(int nums[], int index, int target, int sum) {
        if(index == nums.length) {
            return false;
        }

        if(sum+nums[index] == target) {
            return true;
        }

        // for(int i = index; i < nums.length; i++) {
            if(backtrack(nums,index+1,target,sum+nums[index])) {
                return true;
            }
            if(backtrack(nums,index+1,target,sum)) {
                return true;
            }
        // }

        return false;
    }
}
