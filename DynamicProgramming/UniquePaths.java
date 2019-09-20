// 62. Unique Paths

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?

// Above is a 7 x 3 grid. How many possible unique paths are there?

// Note: m and n will be at most 100.

// Example 1:
// Input: m = 3, n = 2
// Output: 3

// Explanation:
// From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Right -> Down
// 2. Right -> Down -> Right
// 3. Down -> Right -> Right

// Example 2
// Input: m = 7, n = 3
// Output: 28

class Solution {
    // Recusion Time Limit Exceeded
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    // Memoise Recusion 0 ms 33.1 MB
    public int uniquePaths2(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        return helper(m, n, mem);
    }

    private int helper(int m, int n, int[][] mem) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        mem[m][n] = helper(m - 1, n, mem) + helper(m, n - 1, mem);

        return mem[m][n];
    }

    // DP 0 ms 33 MB
    public int uniquePaths3(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        mem[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }
        return mem[m][n];
    }
}