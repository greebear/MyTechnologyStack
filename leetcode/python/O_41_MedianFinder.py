from heapq import  *
class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.A = list() # 小顶堆 大数 正数
        self.B = list() # 大顶堆 小数 负数

    def addNum(self, num: int) -> None:
        if len(self.A) == len(self.B):
            heappush(self.A, -heappushpop(self.B, -num))
        else:
            heappush(self.B, -heappushpop(self.A, num))

    def findMedian(self) -> float:
        if len(self.A) == len(self.B): return (self.A[0] - self.B[0])/2
        else: return self.A[0]

