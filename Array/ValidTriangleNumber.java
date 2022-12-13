import java.util.Arrays;

// 611. Valid Triangle Number

// Given an array consists of non-negative integers, your task is to count the number of triplets 
// chosen from the array that can make triangles if we take them as side lengths of a triangle.

// Example 1:
// Input: [2,2,3,4]
// Output: 3

// Explanation:
// Valid combinations are: 
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3

// Note:
// The length of the given array won't exceed 1000.
// The integers in the given array are in the range of [0, 1000].

class ValidTriangleNumber {
    // Sort and Greedy Algorithm O(n^2) 4 ms 37.7 MB
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int l = nums.length - 1; l > 1; l--) {
            int s = 0, m = l - 1;
            while (s < m) {
                if (nums[s] + nums[m] > nums[l]) {
                    ans += m - s;
                    m--;
                } else {
                    s++;
                }
            }
        }
        return ans;
    }
}