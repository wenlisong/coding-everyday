# -*- coding:utf-8 -*-
# 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
# 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
# (注意: 在返回值的list中，数组长度大的数组靠前)


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 返回二维列表，内部每个列表表示找到的路径
    def FindPath(self, root, expectNumber):
        res = []
        if root:
            if not root.left and not root.right and root.val == expectNumber:
                res.append([root.val])
            elif root.val < expectNumber:
                left_path = self.FindPath(root.left, expectNumber-root.val)
                right_path = self.FindPath(root.right, expectNumber-root.val)
                # we don't need check if the sum equals expect number, if does not equal, we will get empty array and never get into 'for loop'
                for subpath in left_path+right_path:
                    res.append([root.val]+subpath)
        return res
