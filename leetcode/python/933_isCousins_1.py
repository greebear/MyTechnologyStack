# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        x_parent, y_parent = None, None
        x_deepth, y_deepth = 0, 0

        def dfs(node: TreeNode, parent: TreeNode, deepth: int):
            nonlocal x, y, x_parent, y_parent, x_deepth, y_deepth
            deepth += 1
            if node.val == x:
                x_deepth = deepth
                x_parent = parent
            if node.val == y:
                y_deepth = deepth
                y_parent = parent

            if x_parent is not None and y_parent is not None:
                return

            if node.left:
                dfs(node.left, node, deepth)
            if node.right:
                dfs(node.right, node, deepth)

        dfs(root, None, 0)

        if x_parent is not y_parent and x_deepth == y_deepth:
            return True

        else:
            return False





