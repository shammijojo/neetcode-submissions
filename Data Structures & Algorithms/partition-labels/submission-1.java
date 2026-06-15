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
            end = lastIndexByCharacter.get(c);
            for(int j = i+1 ; j <= end ;j++) {
                end = Math.max(end,lastIndexByCharacter.get(s.charAt(j)));
            }
            result.add(end-i+1);
            i = end;
            
        }

        return result;



    }
}
