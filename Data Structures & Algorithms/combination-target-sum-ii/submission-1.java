class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result,new ArrayList<>(),candidates,0,target,0);
        return result;
    }

    private void findCombinations(List<List<Integer>> result, List<Integer> subset, int arr[],
    int index, int target, int sum) {
        if(sum==target && !result.contains(subset)) {
            result.add(new ArrayList<>(subset));
        }
        if(sum > target) {
            return;
        }

        for(int i = index;i < arr.length;i++) {
            subset.add(arr[i]);
            findCombinations(result,subset,arr,i+1,target,sum+arr[i]);
            subset.remove(subset.size()-1);
        }
    }





}
