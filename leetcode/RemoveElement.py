# Given an array nums and a value val, remove all instances of that value in-place and return the new length.
# Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
# The order of elements can be changed. It doesn't matter what you leave beyond the new length.
class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        idx = 0
        i = 0
        while i < len(nums) - idx:
            if nums[i] == val:
                idx += 1
                nums[i] = nums[-idx]
            else:
                i += 1
        return len(nums) - idx


def main():
    nums = [0, 1, 2, 2, 3, 0, 4, 2]
    val = 2
    # return length = 5
    solu = Solution()
    res = solu.removeElement(nums, val)
    print(res)


if __name__ == '__main__':
    main()
