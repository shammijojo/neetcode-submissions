class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, 0,nums);
        return result;
    }

    private void backtrack(List<Integer> list, List<List<Integer>> result,
    int index, int nums[]) {
       
        result.add(new ArrayList<>(list));
        

        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(list,result,i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
