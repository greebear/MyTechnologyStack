class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

p = TreeNode(0)
q = TreeNode(0)
print(p==q)