class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = list()
        right = [0] * len(nums)

        product = 1
        for x in nums:
            left.append(product)
            product *= x

        product = 1
        for i in range(len(nums)-1,-1,-1):
            right[i] = left[i]*product
            product *= nums[i]

        return right 

        
        