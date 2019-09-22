// 300. Longest Increasing Subsequence

// Given an unsorted array of integers, find the length of longest increasing subsequence.

// Example:

// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
// Note:

// There may be more than one LIS combination, it is only necessary for you to return the length.
// Your algorithm should run in O(n2) complexity.
// Follow up: Could you improve it to O(n log n) time complexity?
class LongestIncreasingSubsequence {
    // DP
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // Memoized Recusion
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] mem = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, helper(nums, mem, i));
        }
        return ans;
    }

    public int helper(int[] nums, int[] mem, int r) {
        if (r == 0) {
            return 1;
        }
        if (mem[r] > 0) {
            return mem[r];
        }
        int len = 1;
        for (int i = 0; i < r; i++) {
            if (nums[r] > nums[i]) {
                len = Math.max(len, helper(nums, mem, i) + 1);
            }
        }
        mem[r] = len;
        return mem[r];
    }

}