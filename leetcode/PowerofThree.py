# Given an integer, write a function to determine if it is a power of three.
# Follow up:
# Could you do it without using any loop / recursion?
import math


class Solution:
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 1:
            return False
        n = math.log10(n) / math.log10(3)
        if n % 1 == 0:
            return True
        else:
            return False