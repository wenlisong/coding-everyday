# Write a function that takes an unsigned integer and returns the number of '1' bits
# it has (also known as the Hamming weight).
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0
        while n > 0:
            res += n&1
            n >>= 1
        return res

    def hammingWeight2(self, n):
        res = 0
        while n > 0:
            res += 1
            n &= n-1
        return res
    # contrains negative number
    def getOne(self, n):
        cnt = 0
        if n < 0:
            n &= 0xffffffff  # only change the sign (fisrt one)
        while n != 0:
            n &= n - 1
            cnt +=1
        return cnt


def main():
    n = 62
    solu = Solution()
    res = solu.hammingWeight(n)
    print(res)
    res2 = solu.hammingWeight2(n)
    print(res2)

    res3 = solu.getOne(-2147483648)
    print(res3)

if __name__ == '__main__':
    main()
