class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>(List.of(nums[i],nums[left],nums[right]));
                    if(!result.contains(list)) {
                        result.add(list);
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;

        

    }
}
