class Solution(object):
    def memLeak(self, memory1, memory2):
        """
        :type memory1: int
        :type memory2: int
        :rtype: List[int]
        """
        time = 1
        while(True):
            if memory1 >= memory2:
                tmp_memory1 = memory1
                memory1 -= time
                if memory1 < 0:
                    memory1 = tmp_memory1
                    break
            else:
                tmp_memory2 = memory2
                memory2 -= time
                if memory2 < 0:
                    memory2 = tmp_memory2
                    break
            time += 1

        return [time, memory1, memory2]



solution = Solution()
print(solution.memLeak(2,2))