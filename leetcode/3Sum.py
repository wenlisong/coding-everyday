# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
# Find all unique triplets in the array which gives the sum of zero.
# Note: The solution set must not contain duplicate triplets.
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums = sorted(nums)
        n = len(nums)
        if n >= 3:
            if nums[0] <= 0:
                for i in range(n - 2):
                    if i > 0 and nums[i] == nums[i - 1]:
                        continue
                    l, r = i + 1, n - 1
                    while l < r:
                        s = nums[i] + nums[l] + nums[r]
                        if s < 0:
                            l += 1
                        elif s > 0:
                            r -= 1
                        else:
                            result.append((nums[i], nums[l], nums[r]))
                            while l < r and nums[l + 1] == nums[l]:
                                l += 1
                            while l < r and nums[r - 1] == nums[r]:
                                r -= 1
                            l += 1
                            r -= 1
                        
        return result
            


def main():
    nums = [-1, 0, 1, 2, -1, -4]
    # A solution set is:
    # [[-1, 0, 1], [-1, -1, 2]]
    solu = Solution()
    res = solu.threeSum(nums)
    print(res)

if __name__ == "__main__":
    main()