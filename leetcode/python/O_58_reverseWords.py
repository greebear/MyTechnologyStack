class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        i, j = len(s)-1, len(s)
        res = []
        while i>= 0:
            while i>=0 and s[i]!=' ': i-=1
            res.append(s[i+1: j])
            while i>= 0 and s[i]==' ': i-=1
            j=i+1
        return " ".join(res)

