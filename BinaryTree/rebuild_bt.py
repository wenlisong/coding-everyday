# -*- coding:utf-8 -*-
# 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
# 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        n = len(pre)
        if n == 0:
            return None
        elif n == 1:
            return TreeNode(pre[0])
        root = TreeNode(pre[0])
        idx = None
        for i in range(n):
            if tin[i] == pre[0]:
                idx = i
        if idx == 0:
            root.right = self.reConstructBinaryTree(pre[1:],tin[1:])
        elif idx == n - 1:
            root.left = self.reConstructBinaryTree(pre[1:], tin[:-1])
        else:
            root.left = self.reConstructBinaryTree(pre[1:1 + idx], tin[:idx])
            root.right = self.reConstructBinaryTree(pre[1 + idx:], tin[idx + 1:])
        
        return root
