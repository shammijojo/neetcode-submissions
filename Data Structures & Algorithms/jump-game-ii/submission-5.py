class Solution:
    def jump(self, nums: List[int]) -> int:
        max_index: int = 0
        jumps : int = 0
        l : int = 0
        r : int = 0

        while r < len(nums) - 1:
            for i in range(l,r+1):
                max_index = max(max_index,nums[i]+i)

            l = r+1
            r = max_index
            jumps += 1    


        return jumps
        