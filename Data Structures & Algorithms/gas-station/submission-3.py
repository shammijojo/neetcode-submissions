class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_cost : int = 0
        total_gas : int = 0
        left_gas : int = 0
        start_point : int = 0

        for i in range(0,len(gas)):
            total_gas += gas[i]
            total_cost += cost[i]
            left_gas += gas[i]-cost[i]

            if left_gas < 0:
                start_point = i+1
                left_gas = 0

        return start_point if total_gas >= total_cost and start_point < len(gas) else -1        

        