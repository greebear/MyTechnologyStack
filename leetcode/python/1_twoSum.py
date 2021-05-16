from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        candidate = {}
        for num in nums:
            wanted = target - num
            if wanted not in candidate:
                candidate[wanted] = num
            else:
                return [num, wanted]
        return [-1]


solution = Solution()
solution.twoSum(nums = [2,7,11,15], target = 9)