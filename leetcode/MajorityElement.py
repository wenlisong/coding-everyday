# Given an array of size n, find the majority element. 
# The majority element is the element that appears more than ⌊ n/2 ⌋ times.
# You may assume that the array is non-empty and the majority element always exist in the array.

class Solution:
    def majorityElement(self, nums):
        count = 0
        majority = None
        for n in nums:
            if majority is None:
                majority = n
                count += 1
            else:
                if count == 0:
                    majority = n
                count += 1 if n == majority else - 1
        return majority

        # nums.sort()
        # return nums[len(nums)//2]
        
def main():
    nums = [2,2,1,1,1,2,2]
    # Output: 2
    solu = Solution()
    res = solu.majorityElement(nums)
    print(res)

if __name__ == '__main__':
    main()