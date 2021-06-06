from typing import List


class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        # i=0, j=0, f(i,j) = grid[0, 0]
        # i=0, j!=0, f(i,j) = f(i, j-1) + grid[i,j]
        # i!=0, j=0, f(i,j) = f(i-1, j) + grid[i,j]
        # i!=0, j!=0, f(i, j) = max(f(i-1, j), f(i, j-1)) + grid[i,j]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i==0 and j ==0: continue
                elif i==0: grid[i][j] += grid[i][j-1]
                elif j==0: grid[i][j] += grid[-1][j]
                else: grid[i][j] += max(grid[i][j-1], grid[i-1][j])

        return grid[-1][-1]