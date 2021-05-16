class Solution:
    def sortSentence(self, s: str) -> str:
        a_list = []


        split = s.split(" ")

        for i in range(len(split)):
            a_list.append("")

        print(split)

        for i in range(len(split)):
            index = split[i][-1]
            print(index)
            a_list[int(index)-1] = split[i][:-1]

        result = " ".join(a_list)

        return result

solution = Solution()
print(solution.sortSentence("is2 sentence4 This1 a3"))