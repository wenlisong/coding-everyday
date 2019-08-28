# -*- coding:utf-8 -*-
# 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
# 要求不能创建任何新的结点，只能调整树中结点指针的指向。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def Convert(self, pRootOfTree):
        if not pRootOfTree:
            return None
        nodes = self.inorderTraversal(pRootOfTree)
        if len(nodes) > 1:
            nodes[0].right = nodes[1]
            nodes[-1].left = nodes[-2]
        for i in range(1, len(nodes)-1):
            nodes[i].left = nodes[i - 1]
            nodes[i].right = nodes[i + 1]

        return nodes[0]

    def inorderTraversal(self, root):
        res = []
        if root:
            if root.left:
                res += self.inorderTraversal(root.left)
            res.append(root)
            if root.right:
                res += self.inorderTraversal(root.right)
        return res


def main():
    root = TreeNode(5)
    root.left = TreeNode(3)
    # root.right = TreeNode(7)
    # root.left.left = TreeNode(1)
    # root.left.right = TreeNode(4)
    # root.right.left = TreeNode(6)
    # root.right.right = TreeNode(9)
    solu = Solution()
    res = solu.Convert(root)
    while res:
        print(res.val)
        res = res.right


if __name__ == "__main__":
    main()
