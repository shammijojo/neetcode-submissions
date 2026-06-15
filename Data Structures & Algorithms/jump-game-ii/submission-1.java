class Solution {
    public int jump(int[] nums) {
        int minJumps = 0;
        int currentJump = 0;
        int maxIndex = 0;
        int l = 0, r = 0;

        while(maxIndex < nums.length-1) {
            for(int i = l; i <= r; i++) {
                maxIndex = Math.max(maxIndex,i+nums[i]);
                l = i;
            }
            l++;
            r = maxIndex;
            minJumps++;
        }

        return minJumps;
    }
}
