# -*- coding:utf-8 -*-
# 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

import math

class Solution:
    def Power(self, base, exponent):
        if exponent == 1 and base != 0:
            return 1
        elif exponent < 0:
            return math.pow(1 / base, -exponent)
        else:
            return math.pow(base, exponent)

        
def main():
    base = 2
    exponent = -3
    solu = Solution()
    res = solu.Power(base, exponent)
    print(res)

if __name__ == "__main__":
    main()