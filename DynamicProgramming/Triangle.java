import java.util.Arrays;
import java.util.List;

// 120. Triangle

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
class Triangle {
    // Space: O(n^2) 2 ms 37.2 MB
    public int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[][] dp = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = triangle.get(i - 1).get(j - 1);
                if (i == 1 && j == 1) {
                    continue;
                } else if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[n]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Space: O(n) 2 ms 37.1 MB
    public int minimumTotal2(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[1][j] = triangle.get(i - 1).get(j - 1);
                if (i == 1 && j == 1) {
                    continue;
                } else if (j == 1) {
                    dp[1][j] += dp[0][j];
                } else if (j == i) {
                    dp[1][j] += dp[0][j - 1];
                } else {
                    dp[1][j] += Math.min(dp[0][j - 1], dp[0][j]);
                }
            }
            int[] tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // O(1) 5 ms 38.5 MB
    public int minimumTotal3(List<List<Integer>> triangle) {
        List<List<Integer>> dp = triangle;

        for (int i = 0; i < dp.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0) {
                    dp.get(i).set(j, dp.get(i).get(j) + dp.get(i - 1).get(j));
                } else if (j == i) {
                    dp.get(i).set(j, dp.get(i).get(j) + dp.get(i - 1).get(j - 1));
                } else {
                    dp.get(i).set(j, dp.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp.get(dp.size() - 1)) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // 2 ms 36.9 MB
    public int minimumTotal4(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[][] dp = new int[n][];
        int row = 0;
        for (List<Integer> list : triangle) {
            dp[row] = new int[row + 1];
            int col = 0;
            for (int num : list) {
                dp[row][col++] = num;
            }
            // for(int j=0;j<list.size();j++){
            // dp[row][j] = list.get(j);
            // }
            row++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[n - 1]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}