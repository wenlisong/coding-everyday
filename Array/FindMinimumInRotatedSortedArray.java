// 153. Find Minimum in Rotated Sorted Array

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2] 
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0

class FindMinimumInRotatedSortedArray {
    // 0 ms 38.6 MB
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