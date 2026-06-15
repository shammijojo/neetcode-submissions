class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(),0,nums,target,0);
        return result;
    }


    private void backtrack(List<List<Integer>> result, List<Integer> subset,
    int index, int[] nums, int target, int sum) {

        if(sum == target && !result.contains(subset)) {
            result.add(new ArrayList<>(subset));
        } 

        for(int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            if(sum+nums[i] <= target) {
                backtrack(result, subset, i, nums, target, sum+nums[i]);
            } else {
                subset.remove(subset.size()-1);
                return;
            }
            subset.remove(subset.size()-1);
        }

    }

}
