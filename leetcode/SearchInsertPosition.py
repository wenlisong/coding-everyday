# Given a sorted array and a target value, return the index if the target is found.
# If not, return the index where it would be if it were inserted in order.
# You may assume no duplicates in the array.


class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # bisect
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left


def main():
    nums = [1, 3, 5, 6]
    target = 7
    # Output: 2
    solu = Solution()
    res = solu.searchInsert(nums, target)
    print(res)


if __name__ == '__main__':
    main()
66