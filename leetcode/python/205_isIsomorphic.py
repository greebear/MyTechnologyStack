
class Solution:

    def isIsomorphic(self, s: str, t: str) -> bool:
        mapA = {}
        mapB = {}
        for i in range(len(t)):
            if t[i] not in mapA:
                mapA[t[i]] = s[i]
            if s[i] not in mapB:
                mapB[s[i]] = t[i]

            if t[i] in mapA or s[i] in mapB:
                if mapA[t[i]] == s[i] and mapB[s[i]] == t[i]:
                    continue
                else:
                    return False

        return True


solution = Solution()
print(solution.isIsomorphic("egg", "add"))
print(solution.isIsomorphic("foo", "bar"))
print(solution.isIsomorphic("paper", "title"))
print(solution.isIsomorphic("a", "a"))
print(solution.isIsomorphic("ab", "ab"))