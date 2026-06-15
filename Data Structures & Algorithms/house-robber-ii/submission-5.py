class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0]*n

        if n == 1:
            return nums[0]

        if n == 2:
            return max(nums[0],nums[1])

        #Case 1: Include 1st and exclude last
        case_1 = self.calculate(0,n-2,nums)
        # print(case_1)
        case_2 = self.calculate(1,n-1,nums)
        # print(case_2)

        return max(case_1,case_2)


    def calculate(self, start: int, end: int, nums: list[int]) -> int:
        n = len(nums)-1
        dp = [0]*n
        dp[0] = nums[start]

        if n == 1:
            return dp[0]

        dp[1] = max(nums[start],nums[start+1])
        index = 2

        for i in range(start+2,end+1):
            dp[index] = max(dp[index-1],dp[index-2]+nums[i])
            print(dp[index])
            index += 1

        return dp[n-1]         
        

        