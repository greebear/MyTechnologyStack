from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # if f(n-1)>0: f(n) = f(n-1) + nums(n-1)
        # if f(n-1)<=0: f(n) = nums(n-1)
        f = [0]*len(nums)
        f[0] = nums[0]
        maxRes = f[0]
        for i in range(1, len(nums)):
            if f[i-1] > 0: f[i] = f[i-1] + nums[i]
            else: f[i] = nums[i]
            maxRes = max(f[i], maxRes)
        return maxRes
