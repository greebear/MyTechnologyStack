class Solution:
    def isValid(self, s: str) -> bool:
        myDict = {
            ")": "(",
            "}": "{",
            "]": "[",
        }
        stack = []
        for ch in s:
            if len(stack) >= 1 and ch in myDict and myDict[ch] == stack[-1]:
                stack.pop()
            else:
                stack.append(ch)

        if len(stack) == 0:
            return True
        else:
            return False