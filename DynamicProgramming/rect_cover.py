# -*- coding:utf-8 -*-
# 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
# 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？


class Solution:
    def rectCover(self, number):
        # write code here
        if number < 1:
            return 0
        elif number == 1:
            return 1
        elif number == 2:
            return 2
        else:
            arr = [1, 2]
            for i in xrange(2, number):
                arr.append(arr[i-1]+arr[i-2])
            return arr[-1]


def main():
    n = 4
    solu = Solution()
    res = solu.rectCover(n)
    print(res)


if __name__ == "__main__":
    main()
