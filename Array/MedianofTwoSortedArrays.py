# There are two sorted arrays nums1 and nums2 of size m and n respectively.
# Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
# You may assume nums1 and nums2 cannot be both empty.
# Example 1:
# nums1 = [1, 3]
# nums2 = [2]
# The median is 2.0

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m, n = len(nums1), len(nums2)
        if m == 0:
            if n % 2:
                return nums2[n / 2]
            else:
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2
        elif n == 0:
            if m % 2:
                return nums2[m / 2]
            else:
                return (nums2[m / 2 - 1] + nums2[m / 2]) / 2
            
        i = j = 0
        tmp1 = tmp2 = None
        while i + j < (m + n) / 2:
            tmp1 = nums1[i]
            tmp2 = nums2[j]
            if nums1[i] < nums2[j]:
                i = (m - i) / 2
            else:
                j = (n - j) / 2
        if (m + n) % 2:
            if nums1[i] == tmp1:
                return tmp2
            else:
                return tmp1
        else:
            if nums1[i] == tmp1:
                return (nums2[j - 1] + nums2[j]) / 2
                

def main():
    nums1 = [1, 3]
    nums2 = [2]
    solu = Solution()
    res = solu.findMedianSortedArrays(nums1, nums2)
    print(res)

if __name__ == "__main__":
    main()
