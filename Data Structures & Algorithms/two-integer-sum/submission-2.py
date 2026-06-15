class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mydict = dict()
        for i in range(len(nums)):
            x = nums[i]
            if target-x in mydict:
                return [mydict[target-x], i]

            if x not in mydict:
                mydict[x] = i

        return [0,0]    

        