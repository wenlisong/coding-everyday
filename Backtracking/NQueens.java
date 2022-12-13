import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51. N-Queens

// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct this.board configuration of the n-queens' placement, 
// where 'Q' and '.' both indicate a queen and an empty space respectively.

// Example:
// Input: 4
// Output: [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

class NQueens {
    private List<List<String>> ans;
    private StringBuilder[] board;
    private boolean[] column;
    private boolean[] diagonal1;
    private boolean[] diagonal2;

    // 2 ms 38 MB
    public List<List<String>> solveNQueens(int n) {
        init(n);
        nQueens(n, 0);
        return this.ans;
    }

    private void init(int n) {
        this.ans = new ArrayList<>();
        this.board = new StringBuilder[n];
        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int i = 0; i < n; i++) {
            this.board[i] = new StringBuilder(String.valueOf(row));
        }
        this.column = new boolean[n];
        Arrays.fill(this.column, true);
        this.diagonal1 = new boolean[2 * n - 1];
        Arrays.fill(this.diagonal1, true);
        this.diagonal2 = new boolean[2 * n - 1];
        Arrays.fill(this.diagonal2, true);
    }

    private boolean isAvailable(int x, int y, int n) {
        return this.column[y] && this.diagonal1[x + y] && this.diagonal2[n - 1 - y + x];
    }

    private void set(int x, int y, int n, boolean state) {
        this.column[y] = state;
        this.diagonal1[x + y] = state;
        this.diagonal2[n - 1 - y + x] = state;
        this.board[x].setCharAt(y, state ? '.' : 'Q');
    }

    private void nQueens(int n, int x) {
        if (x >= n) {
            List<String> solution = new ArrayList<>();
            for (StringBuilder sb : this.board) {
                solution.add(sb.toString());
            }
            this.ans.add(solution);
            return;
        }
        for (int y = 0; y < n; y++) {
            if (isAvailable(x, y, n)) {
                set(x, y, n, false);
                nQueens(n, x + 1);
                set(x, y, n, true);
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        NQueens solu = new NQueens();
        List<List<String>> ans = solu.solveNQueens(4);
        for (List<String> board : ans) {
            for (String line : board) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}