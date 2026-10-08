class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];
        lis[nums.length-1] = 1;

        int maxlis = 1;

        for(int i = nums.length-2; i >= 0; i--) {
            int max = 1;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    max = Math.max(max, lis[j]+1);
                }
            }
            lis[i] = max;
            maxlis = Math.max(maxlis,max);
        }

        return maxlis;
    }
}
