import java.util.Arrays;

// 268. Missing Number

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:

// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8
// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
class Solution {
    // Sum Method 0 ms 39.2 MB
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        return n * (n + 1) / 2 - sum;
    }

    // XOR Method 0 ms 39.6 MB
    public int missingNumber2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans ^= i ^ nums[i];
        }
        ans ^= n;
        return ans;
    }
}