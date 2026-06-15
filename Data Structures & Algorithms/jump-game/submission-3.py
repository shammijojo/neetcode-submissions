class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_index = 0

        for i in range(0,len(nums)):
            if(max_index < i):
                return False

            max_index = max(max_index,nums[i]+i)
            if(max_index >= len(nums)-1):
                return True

        return False            

        


