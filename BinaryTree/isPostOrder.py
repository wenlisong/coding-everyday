# -*- coding:utf-8 -*-
# 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
# 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。


class Solution:
    def VerifySquenceOfBST(self, sequence):
        if len(sequence) <= 0:
            return False
        elif len(sequence) == 1:
            return True
        else:
            mid = 0
            i = 0
            while i < len(sequence)-1 and sequence[i] < sequence[-1]:
                i += 1
            mid = i
            while i < len(sequence) - 1:
                if sequence[i] < sequence[-1]:
                    return False
                i += 1
            return (self.VerifySquenceOfBST(sequence[:mid]) or mid == 0) and (self.VerifySquenceOfBST(sequence[mid:len(sequence) - 1]) or mid == len(sequence)-1)


def main():
    arr = [1, 2, 3, 4, 5]
    solu = Solution()
    res = solu.VerifySquenceOfBST(arr)
    print(res)


if __name__ == "__main__":
    main()
