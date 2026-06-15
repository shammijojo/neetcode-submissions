class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0,target,0,nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset,
    int sum, int target, int index, int[] nums) {
        if(sum == target && !result.contains(subset)) {
            result.add(new ArrayList<>(subset));
        }

        for(int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(result,subset,sum+nums[i],target,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }
}
