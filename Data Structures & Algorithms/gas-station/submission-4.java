class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int totalGas = 0;
        int totalCost = 0;
        int index = 0;

        for(int  i = 0 ; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i]-cost[i];

            if(currentGas < 0) {
                currentGas = 0;
                index = i+1;
            }
        }

        return totalGas >= totalCost ? index : -1;
    }
}
