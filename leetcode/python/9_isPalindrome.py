class Solution:
    def isPalindrome(self, x: int) -> bool:
        reversedNum = 0
        # 边界条件
        if x < 0 or (x % 10 == 0 and x == 0): return False
        while x > reversedNum:
            tmp = x % 10
            reversedNum = 10 * reversedNum + tmp
            x // 10

        return reversedNum == x or reversedNum // 10 == x

