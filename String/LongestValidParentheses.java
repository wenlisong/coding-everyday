import java.util.Stack;

// 32. Longest Valid Parentheses
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// Example 1:
// Input: "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()"

// Example 2:

// Input: ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()"

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int leftIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    leftIndex = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - leftIndex);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")())))(())";
        LongestValidParentheses solu = new LongestValidParentheses();
        int rst = solu.longestValidParentheses(s);
        System.out.println(rst);
    }
}