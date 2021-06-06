from typing import List


class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        i, j = 1,3
        s = 3
        res = []
        while i+1<j:
            if s==target:
                res.append(list(range(i,j)))
            if s<target:
                s += j
                j += 1
            else:
                s -= i
                i += 1

        return res