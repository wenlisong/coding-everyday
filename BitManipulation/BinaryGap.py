# Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
# If there aren't two consecutive 1's, return 0.

class Solution:
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        pre = None
        cur = 0
        dist = 0
        while N > 0:
            if N % 2:
                if pre is None:
                    pre = cur
                else:
                    dist = max(dist, cur - pre)
                    pre = cur
            N //= 2
            cur += 1
        return dist

def main():
    N = 5
    # Output: 2
    # Explanation: 
    # 5 in binary is 0b101.
    solu = Solution()
    res = solu.binaryGap(N)
    print(res)

if __name__ == "__main__":
    main()