from typing import List


class Solution:
    def minArray(self, numbers: List[int]) -> int:
        i, j, mid= 0, len(numbers)-1, 0
        while i<= j:
            mid = (i+j)//2
            if numbers[mid] > numbers[j]: i = mid + 1
            elif numbers[mid] < numbers[j]: j = mid
            else : j -= 1
        return numbers[mid]

    def betterMinArray(self, numbers: [int]) -> int:
        i, j = 0, len(numbers) - 1
        while i < j:
            m = (i + j) // 2
            if numbers[m] > numbers[j]: i = m + 1
            elif numbers[m] < numbers[j]: j = m
            else: j -= 1
        return numbers[i]



c1 = [1,3,5]
c2 = [3,4,5,1,2]
c3 = [2,2,2,0,1]
c4 = [1]
c5 = [3,1]

solution = Solution()
print(solution.minArray(c1))
print(solution.minArray(c5))