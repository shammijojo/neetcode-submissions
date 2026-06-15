class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> sum = new ArrayList<>();
        int carry = 0, total = 0;

        for(int i = digits.length-1; i >= 0; i--) {
            if(i == digits.length-1) {
                total=digits[i]+1;
            } else {
                total = digits[i]+carry;
            }
            sum.add(total%10);
            carry = total/10;
        }
        if(carry==1) {
            sum.add(1);
        }

        Collections.reverse(sum);
        return sum.stream().mapToInt(Integer::intValue).toArray();
    }
}
