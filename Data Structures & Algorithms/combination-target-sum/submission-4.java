class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(),result,0,nums,target,0);
        return result;
    }

    private void backtrack(List<Integer> subset, List<List<Integer>> result,
    int index, int nums[], int target, int sum) {
        if(sum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(sum+nums[i] <= target) {
                subset.add(nums[i]);
                backtrack(subset,result,i,nums,target,sum+nums[i]);
                subset.remove(subset.size()-1);
            } else {
                return;
            }
        }
    }
}
