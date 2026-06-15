class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastIndexByCharacter = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndexByCharacter.put(c,i);
        }


        int end = 0;
        int startIndex = 0;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end,lastIndexByCharacter.get(c));
            if(i >= end) {
                result.add(end-startIndex+1);
                startIndex=i+1;
            }
        }

        return result;



    }
}
