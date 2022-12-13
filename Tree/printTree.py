# -*- coding:utf-8 -*-
# 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    # 返回从上到下每个节点值列表，例：[1,2,3]
    def PrintFromTopToBottom(self, root):
        nodes = []
        if root:
            nodes.append(root)
            for node in nodes:
                if node.left:
                    nodes.append(node.left)
                if node.right:
                    nodes.append(node.right)
            return [x.val for x in nodes]
        else:
            return []
        
def main():
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    solu = Solution()
    res = solu.PrintFromTopToBottom(root)
    print(res)
    
if __name__ == "__main__":
    main()