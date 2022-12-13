# -*- coding:utf-8 -*-
# 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
# 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        pri_num = None
        appear_times = 0
    
        for num in numbers:
            if pri_num == None or appear_times <= 0:
                pri_num = num
            if num == pri_num:
                appear_times += 1
            else:
                appear_times -= 1
        
        appear_times = 0
        for num in numbers:
            if pri_num == num:
                appear_times += 1
        if appear_times > len(numbers) / 2:
            return pri_num
        else:
            return 0

def main():
    arr=[1,2,3,2,4,2,5,2,3]
    solu = Solution()
    res = solu.MoreThanHalfNum_Solution(arr)
    print(res)

if __name__ == "__main__":
    main()