class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int product = n;

        while(product!=1) {
            product = square(product);
            if(set.contains(product)) {
                return false;
            }
            set.add(product);
        }

        return true;
    }

    private int square(int n) {
        int total = 0;
        while(n > 0) {
            int rem = n%10;
            total+=rem*rem;
            n=n/10;
        }
        return total;
    }
}
