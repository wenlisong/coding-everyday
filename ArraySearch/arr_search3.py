# -*- coding:utf-8 -*-
# 输入n个整数，找出其中最小的K个数。
# 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        res = []
        if len(tinput) < k or k <= 0:
            return res
        for num in tinput:
            if len(res) < k:
                self.insert(res, num)
            else:
                if res[-1] > num:
                    res.pop()
                    self.insert(res, num)
        return res
        
    def insert(self, arr, num):
        if not arr:
            arr.append(num)
        else:
            for idx, val in enumerate(arr):
                if num < val:
                    arr.insert(idx, num)
                    break
            else:
                arr.append(num)

def main():
    tinput = [4, 5, 1, 6, 2, 7, 3, 8]
    k = 0
    solu = Solution()
    res = solu.GetLeastNumbers_Solution(tinput, k)
    print(res)

if __name__ == "__main__":
    main()