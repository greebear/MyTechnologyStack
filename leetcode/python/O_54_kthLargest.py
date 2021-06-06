# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
        def dfs(node: TreeNode):
            if not node: return
            dfs(node.right)
            print(node.val)
            self.k -= 1
            if self.k == 0: self.res = node.val
            dfs(node.left)

        self.k = k
        self.res = -1

        dfs(root)
        return self.res
