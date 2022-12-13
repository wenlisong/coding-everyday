# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        # solve it without converting the integer to a string
        if x < 0 or (x != 0 and x % 10 == 0):
            return False
        y = 0
        while x > y:
            remainder = x % 10
            x //= 10
            y *= 10
            y += remainder
        return (x == y) or (x == y // 10)


def main():
    x = -121
    # Output: false
    solu = Solution()
    print(solu.isPalindrome(x))


if __name__ == "__main__":
    main()
