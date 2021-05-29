from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        combination = list()
        combinations = list()
        phoneMap = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }

        def backtrack(index:int):
            if index == len(digits):
                combinations.append("".join(combination))
                return
            else:
                for letter in phoneMap[digits[index]]:
                    combination.append(letter)
                    backtrack(index+1)
                    combination.pop()
        if digits== "": return list()
        backtrack(0)

        return combinations
