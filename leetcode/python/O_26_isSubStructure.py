# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        if A is None or B is None: return False
        if self.recur(A, B): return True
        return self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)

    def recur(self, nA, nB):
        if nB is None: return True  # B遍历完，说明存在子树
        if nA is None or nA.val != nB.val: return False
        return self.recur(nA.left, nB.left) and self.recur(nA.right, nB.right)