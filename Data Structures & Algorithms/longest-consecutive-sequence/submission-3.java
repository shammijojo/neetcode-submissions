class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0, len = 1;

        for(int num : nums) {
            len =1;
            if(!elements.contains(num-1)) {
                while(elements.contains(num+1)) {
                    num++;
                    len++;
                }
            }
            max = Math.max(len,max);
        }

        return max;


    }
}
