class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;

        for(int i = 0 ;i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            if(i > 0 &&  nums[i] == nums[i-1]) continue;

            while(left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) {
                    left++;
                    }
                    while(right > left && nums[right] == nums[right+1]) {
                    right--;
                    }
                } else if(sum < target) {
                    left++;       
                } else {
                    right--;
                }
            }          
        }

        return result;
    }
}
