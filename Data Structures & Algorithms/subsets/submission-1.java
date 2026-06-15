class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),0,nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset,
    int index, int[] nums) {
        if(!subset.contains(subset)) {
            result.add(new ArrayList<>(subset));
        }

        for(int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(result,subset,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }


}
