import random


class Solution:

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.vals = nums

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.vals
        

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        # Method 1
        # vals = self.vals.copy() # very important to use 'copy' function
        # random.shuffle(vals)
        # return vals
        # Method 2
        return sorted(self.vals, key=lambda x: random.random())
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()