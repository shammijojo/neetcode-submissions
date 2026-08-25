class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];

        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) change[0]++;
            else if(bills[i] == 10) change[1]++;
            else change[2]++;

            int diff = bills[i] - 5;
            while(diff > 0) {
                if(diff == 5) {
                    change[0]--;
                    diff -= 5;
                } else if(diff >= 10) {
                    if(change[1] > 0) {
                        change[1]--;
                    } else {
                        change[0] -= 2;
                    }
                    diff -= 10;
                }
            }

            if(change[0] < 0) return false;
        }

        return true;
    }
}