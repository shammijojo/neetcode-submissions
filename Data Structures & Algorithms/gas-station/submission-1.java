class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int station = 0;



        for(int i = 0; i < gas.length; i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];

            currentGas = currentGas+gas[i]-cost[i];
            if(currentGas < 0) {
                currentGas = 0;
                station = i+1;
            }
        }

        return (totalGas < totalCost) ? -1 : station;


    }
}
