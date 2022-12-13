# -*- coding:utf-8 -*-

# 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
# 求该青蛙跳上一个n级的台阶总共有多少种跳法。
class Solution:
    def jumpFloorII(self, number):
        # write code here
        if number < 2:
            return 1
        elif number == 2:
            return 2
        else:
            res = 0
            for i in range(0,number):
                res += self.jumpFloorII(i)
            return res
        # Method 2
        # return 2**(number - 1)