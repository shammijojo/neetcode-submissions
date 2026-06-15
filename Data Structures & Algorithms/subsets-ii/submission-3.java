class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, 0,nums);
        return result;
    }

    private void backtrack(List<Integer> subset, List<List<Integer>> result,
    int index, int nums[]) {
        if(!result.contains(subset)) {
            result.add(new ArrayList<>(subset));
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[index]) continue;
            subset.add(nums[i]);
            backtrack(subset,result,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }
}
