class Solution:
    def cuttingRope(self, n: int) -> int:
        # f(i) = max(j*(i-j), j*f(i-j))
        f = [0]*(n+1)
        f[0] = 0
        for i in range(1, n+1):
            for j in range(1, i+1):
                tmp = max(j*(i-j), j*f[i-j])
                f[i] = max(f[i], tmp)
        return int(f[n]%(1e9+7))