class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;

            if(!elements.contains(num-1)) {
                while(elements.contains(num)) {
                    count++;
                    num++;
                }
            }

            max = Math.max(max,count);
        }

        return max;
    }
}
