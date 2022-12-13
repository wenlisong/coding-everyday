# Reverse bits of a given 32 bits unsigned integer.
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        return int("{0:032b}".format(n)[::-1], 2)
        
    def reverseBits2(self, n):
        res = 0
        for i in range(32):
            res <<= 1
            res += n & 1
            n >>= 1
        return res
            
def main():
    n = 43261596
    # Output: 964176192
    solu = Solution()
    res = solu.reverseBits(n)
    print(res)
    res2 = solu.reverseBits2(n)
    print(res2)

if __name__ == '__main__':
    main()