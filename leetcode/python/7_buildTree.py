# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        dic = {}
        for i in range(len(inorder)):
            dic[inorder[i]] = i

        def dfs(pre_root, in_left, in_right):
            if in_left>in_right: return
            node = TreeNode(preorder[pre_root])
            mid = dic[node.val]
            node.left = dfs(pre_root+1, in_left, mid-1)
            node.right = dfs(pre_root+(mid-in_left)+1, mid+1, in_right)

            return node

        root = dfs(0,0, len(preorder)-1)
        return root
