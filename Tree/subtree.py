# coding=utf-8
# 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 1.Find the root node with same value
    # 2.Check if pRoot2 is the subtree of pRoot1
    #   2.1. Yes: return True
    #   2.2. No: find the root node with same value in the left and right subtree of pRoot1, 
    # 3.Check if pRoot2 is the left or right subtree of pRoot1,
    #   jump to 2.1 or 2.2

    def HasSubtree(self, pRoot1, pRoot2):
        if pRoot1 and pRoot2:
            return self.isSubTree(pRoot1,pRoot2) or self.HasSubtree(pRoot1.left, pRoot2) or self.HasSubtree(pRoot1.right, pRoot2)
        else:
            return False
        
    def isSubTree(self, tree1, tree2):
        if not tree2:
            return True
        elif not tree1:
            return False
        elif tree1.val == tree2.val:
            return self.isSubTree(tree1.left, tree2.left) and self.isSubTree(tree1.right, tree2.right)
        

