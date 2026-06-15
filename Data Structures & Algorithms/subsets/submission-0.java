class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(new ArrayList<>(),result,nums,0);
        return result;
    }


    private void buildSubsets(List<Integer> currentList, List<List<Integer>> result,
    int arr[],int index) {
        
        if(!result.contains(currentList)) {
            result.add(new ArrayList<>(currentList));
        }


        for(int i = index; i < arr.length; i++) {
            currentList.add(arr[i]);
            buildSubsets(currentList,result,arr,i+1);
            currentList.remove(currentList.size()-1);
        }

    }

}
