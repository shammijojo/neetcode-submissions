class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalPetrol = 0, totalDistance = 0;
        int currentPetrol = 0, index = 0;


        for(int i = 0; i < gas.length; i++) {
            totalPetrol += gas[i];
            totalDistance += cost[i]; 
            currentPetrol += gas[i]-cost[i];

            if(currentPetrol < 0) {
                index = i+1;
                currentPetrol = 0;
            }
        }

        if(totalDistance > totalPetrol || index >= gas.length) {
            return -1;
        }

        return index;
    }
}
