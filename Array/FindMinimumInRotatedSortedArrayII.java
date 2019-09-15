// 154. Find Minimum in Rotated Sorted Array II

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

// Find the minimum element.

// The array may contain duplicates.

// Example 1:

// Input: [1,3,5]
// Output: 1
// Example 2:

// Input: [2,2,2,0,1]
// Output: 0
// Note:

// This is a follow up problem to Find Minimum in Rotated Sorted Array.
// Would allow duplicates affect the run-time complexity? How and why?

class FindMinimumInRotatedSortedArrayII {
    // O(n) 0 ms 37.2 MB
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            int mid = left + (right - left) / 2;
            return Math.min(helper(nums, left, mid), helper(nums, mid + 1, right));
        }
    }
}