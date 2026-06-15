class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i)-'a']++;
        }

        int start = 0;
        for(int i = 0; i < s2.length(); i++) {
            s2arr[s2.charAt(i)-'a']++;

            if(i >= s1.length()) {
                s2arr[s2.charAt(start)-'a']--;
                start++;
            }

            if(Arrays.equals(s1arr,s2arr)) {
                return true;
            }
        }

        return false;
    }
}
