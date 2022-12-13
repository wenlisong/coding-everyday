# coding=utf-8
# n个骰子 每个骰子的值可以是1到Xi 等概率出现
# 每次取n个骰子最大的值作为结果 求期望
# Example:
# n = 2
# Xi = 2 2
# 可能的结果有 1 1， 1 2， 2 1， 2 2
# 最终的取值对应为 1， 2， 2， 2
# 期望就是 1.75 
import sys

if __name__ == "__main__":
    # n = int(sys.stdin.readline().strip())
    n = 3
    nums = list(map(int, "3 2 1".strip().split()))
    nums.sort()
    print(nums)
    expect = [0]
    for i in range(1, nums[-1]+1):
        tmp = 1
        for num in nums:
            if i <= num:
                tmp *= i/num
                # print(tmp)
        expect.append(tmp-sum(expect[:i]))
    print(expect)
    ans = 0
    for i in range(len(expect)):
        ans += i*expect[i]
    print("%.2f" %ans)
