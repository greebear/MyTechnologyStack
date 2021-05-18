class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows < 2: return s
        res = ["" for _ in range(numRows)]
        flag = -1
        i = 0
        for c in s:
            if i == 0 or i == numRows - 1: flag = -flag
            res[i] += c
            i += flag

        return "".join(res)