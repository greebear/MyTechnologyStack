from typing import  List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_time_dict = {}
        res = [[] for i in range(len(nums) + 1)]
        for i in nums:
            if i in nums_time_dict:
                nums_time_dict[i] += 1
            else:
                nums_time_dict[i] = 1

        for num, times in nums_time_dict.items():
            res[times].append(num)

        ans = []
        for i in range(len(nums), 0, -1):
            if len(res[i]) == 0:
                continue
            ans.extend(res[i])
            if len(ans) == k:
                return ans