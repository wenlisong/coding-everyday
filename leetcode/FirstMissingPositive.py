# Given an unsorted integer array, find the smallest missing positive integer.

class Solution:
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numdict = {}
        n = len(nums) + 1
        while nums:
            num = nums.pop()
            if num > 0 and num < n:
                numdict[num] = True
        missing_num = 1
        while True:
            if not numdict.get(missing_num):
                return missing_num
            missing_num += 1


def main():
    nums = [3, 4, -1, 1]
    # Output: 2
    solu = Solution()
    result = solu.firstMissingPositive(nums)
    print(result)

if __name__ == '__main__':
    main()