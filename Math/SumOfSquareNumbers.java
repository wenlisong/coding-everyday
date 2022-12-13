// 633. Sum of Square Numbers

// Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

// Example 1:
// Input: 5
// Output: True
// Explanation: 1 * 1 + 2 * 2 = 5

// Example 2:
// Input: 3
// Output: False

class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int upper = (int) Math.sqrt(c);

        for (int a = 0; a <= upper; a++) {
            int b = (int) Math.round(Math.sqrt(c - a * a));
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }
}