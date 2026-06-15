class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        max_sum = -2**31
        for x in nums:
            sum += x
            max_sum = max(sum,max_sum)

            if(sum < 0):
                sum = 0

        return max_sum        

        