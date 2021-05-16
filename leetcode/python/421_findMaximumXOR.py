from typing import List

max_deepth = 30  # 31


class Trie:
    def __init__(self):
        self.left = None  # 1
        self.right = None  # 0

    def generate_trie_tree(self, num: int):
        node = self
        for deepth in range(max_deepth, -1, -1):
            tmp_num = num >> deepth
            res = tmp_num & 1
            # 如果res为1，则deepth位为1;
            if res == 1:
                if not node.left:
                    node.left = Trie()
                node = node.left

            # 如果res为0，则deepth位为0
            else:
                if not node.right:
                    node.right = Trie()
                node = node.right

    def maxXOR(self, num):
        node = self
        x = 0
        for deepth in range(max_deepth, -1, -1):
            tmp_num = num >> deepth
            res = tmp_num&1
            # 如果res为1，则num的deepth位为1;
            if res == 1:
                if node.right:
                    node = node.right
                    x = x*2 + 1
                else:
                    node = node.left
                    x = x*2
            # 如果res为0，则num的deepth位为0
            else:
                if node.left:
                    node = node.left
                    x = x*2 + 1
                else:
                    node = node.right
                    x = x*2
        return x


class Solution:

    def findMaximumXOR(self, nums: List[int]) -> int:
        max_res = 0
        # 字典生成树
        root = Trie()
        for num in nums:
            root.generate_trie_tree(num)
        # 检索
        for num in nums:
            res = root.maxXOR(num)
            max_res = max(max_res, res)

        return max_res
