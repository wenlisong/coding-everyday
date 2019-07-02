# 29. Divide Two Integers
# Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

# Return the quotient after dividing dividend by divisor.

# The integer division should truncate toward zero.

# Example 1:

# Input: dividend = 10, divisor = 3
# Output: 3
# Example 2:

# Input: dividend = 7, divisor = -3
# Output: -2
# Note:

# Both dividend and divisor will be 32-bit signed integers.
# The divisor will never be 0.
# Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend < -2 ** 31 or dividend > 2 ** 31 - 1:
            raise ValueError('Out of boudary!')

        if dividend == -2 ** 31 and divisor == -1:
            return 2 ** 31 - 1
        sign = -1 if (dividend > 0) ^ (divisor > 0) else 1
        dividend = dividend if dividend > 0 else - dividend
        divisor = divisor if divisor > 0 else - divisor
        quotient = 0
        while dividend >= divisor:
            tmp, shift = divisor, 1
            while dividend >= tmp << 1:
                tmp <<= 1
                shift <<= 1
            dividend -= tmp
            quotient += shift

        return quotient * sign


if __name__ == "__main__":
    solu = Solution()
    ret = solu.divide(7, -3)
    print(ret)