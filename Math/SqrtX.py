# 69.Sqrt(x)
# Implement int sqrt(int x).

# Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

# Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

# Example 1:

# Input: 4
# Output: 2
# Example 2:

# Input: 8
# Output: 2
# Explanation: The square root of 8 is 2.82842..., and since 
#              the decimal part is truncated, 2 is returned.
import math


class Solution:
    def mySqrt(self, x: int) -> int:
        '''
        r^2 = x
        f(r) = r^2 - x
        f'(r) = 2r
        r_{n+1} = r_n - f(r_n) / f'(r_n)
                = r_n - (r_n / 2 - x / 2r_n)
                = r_n / 2 + x / 2r_n
        '''
        epsilon = 1e-6
        r = x
        while r * r - x > epsilon:
            r = r / 2 + x / (2 * r)
            # print(r)
        # only return the integer part 
        return math.floor(r)

if __name__ == "__main__":
    solu = Solution()
    res = solu.mySqrt(8)
    print(res)