from typing import List


class Solution:
    def printNumbers(self, n: int) -> List[int]:
        if n == 0: return list()
        def dfs(index: int):
            if index==n:
                combinations.append(int("".join(combination)))
            else:
                for i in range(0, 10):
                    combination.append(str(i))
                    dfs(index+1)
                    combination.pop()

        combinations = []
        combination = []

        dfs(0)
        return combinations[1:]