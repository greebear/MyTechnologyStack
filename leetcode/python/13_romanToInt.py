class Solution:
    SYMBOL_VALUE = [
        ("M",1000),
        ("CM", 900),
        ("D", 500),
        ("CD", 400),
        ("C", 100),
        ("XC", 90),
        ("L", 50),
        ("XL", 40),
        ("X", 10),
        ("IX", 9),
        ("V", 5),
        ("IV", 4),
        ("I", 1),
    ]

    def romanToInt(self, s: str) -> int:
        num = 0
        index = 0
        length = len(s)
        for key, value in Solution.SYMBOL_VALUE:
            while(True):
                # index超出范围 退出
                if index >= length: break
                # 取一个数进行比较
                if s[index] == key:
                    # 匹配了 index+1 继续while
                    num += value
                    index += 1
                    continue
                # 取两个数进行比较
                elif s[index:index+2] == key:
                    # 匹配了 index+3 继续while
                    num += value
                    index += 2
                    continue
                # 都不匹配进入下一个key
                else:
                    break

        return num


solution = Solution()
print(solution.romanToInt("III"))
print(solution.romanToInt("IV"))
print(solution.romanToInt("IX"))
print(solution.romanToInt("MCMXCIV"))  # 1994
