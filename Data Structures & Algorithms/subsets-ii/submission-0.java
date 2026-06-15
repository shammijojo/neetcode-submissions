class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(result,new ArrayList<>(),nums,0);
        return result;
    }


    private void findSubsets(List<List<Integer>> result, List<Integer> subset, int[] arr,
    int index) {
        if(!result.contains(subset)) {
            result.add(new ArrayList<>(subset));
        }

        for(int i = index; i < arr.length; i++) {
            subset.add(arr[i]);
            findSubsets(result,subset,arr,i+1);
            subset.remove(subset.size()-1);
        }
    }


}
