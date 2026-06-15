class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int l = 0, r = 0;

        while(maxReach < nums.length-1) {
            for(int i = l; i <= r; i++) {
                maxReach = Math.max(maxReach,i+nums[i]);
            }
            l = r+1;
            r = maxReach;
            jumps++;
        }

        return jumps;
    }
}
