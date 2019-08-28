# The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

# Given two integers x and y, calculate the Hamming distance.


class Solution:
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        return self.NumberOfOne(x^y)
        
    def NumberOfOne(self, num):
        """
        :type num: int
        :rtype: int
        """
        res = 0
        while num > 0:
            res += 1
            num &= num - 1
        return res


def main():
    solu = Solution()
    print(bin(93))
    print(bin(73))
    res = solu.hammingDistance(93, 73)
    print(res)

if __name__ == '__main__':
    main()