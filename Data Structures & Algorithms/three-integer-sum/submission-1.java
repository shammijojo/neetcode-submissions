class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int start = i+1, end = nums.length-1;
            int target = 0;

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target) {
                    end--;
                } else if(sum < target) {
                    start++;
                } else {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i],nums[start],nums[end]});
                    if(!result.contains(list)) {
                        result.add(list);
                    }
                    start++;
                    end--;
                }
            }
        }

            return result;
    }
}
