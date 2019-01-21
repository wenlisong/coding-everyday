# Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
# find the one that is missing from the array.


class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        missing_n = int((0 + n) * (n+1) / 2) - sum(nums)
        return missing_n

def main():
    input = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    # Output: 8
    solu = Solution()
    res = solu.missingNumber(input)
    print(res)
    input = [0]
    print(solu.missingNumber(input))


if __name__ == '__main__':
    main()
