class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int minJumps = 0;
        int maxIndex = 0;

        if(nums.length == 1) {
            return 0;
        }

        while(end < nums.length-1) {
            for(int i = start; i <= end; i++) {
                maxIndex = Math.max(maxIndex,i+nums[i]);
            }
            start = end+1;
            end = maxIndex;
            minJumps++;
        }

        return minJumps;
        
    }
}
