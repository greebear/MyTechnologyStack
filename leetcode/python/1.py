class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        counters = [0]*(len(nums))
        counters_map = dict()
        counters_map[-1] = count
        for index in range(len(nums)):
            if nums[index] == 0:
                count += -1
            if nums[index] == 1:
                count += 1

            if count not in counters_map: counters_map[count] = index
            else: pass