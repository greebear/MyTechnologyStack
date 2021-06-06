# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # 后序遍历
        def dfs(node, p, q):
            # 判断是否存在p或q，返回TreeNode
            # 存在返回p或q
            # 不存在返回node=None
            if not node or p.val == node.val or q.val == node.val: return node
            left = dfs(node.left, p, q)
            right = dfs(node.right, p, q)
            if not left and not right: return
            if not left: return right
            if not right: return left
            return node

        res = dfs(root, p, q)
        return res
