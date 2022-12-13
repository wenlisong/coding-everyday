import java.util.*;

// 241. Different Ways to Add Parentheses

// Given a string of numbers and operators, return all possible results from computing all the different possible ways 
// to group numbers and operators. The valid operators are +, - and *.

// Example 1:
// Input: "2-1-1"
// Output: [0, 2]
// Explanation: 
// ((2-1)-1) = 0 
// (2-(1-1)) = 2

// Example 2:
// Input: "2*3-4*5"
// Output: [-34, -14, -10, -10, 10]
// Explanation: 
// (2*(3-(4*5))) = -34 
// ((2*3)-(4*5)) = -14 
// ((2*(3-4))*5) = -10 
// (2*((3-4)*5)) = -10 
// (((2*3)-4)*5) = 10
class DifferentWaysToAddParentheses {
    // Recusion Memoize 1 ms	35.1 MB
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> mem = new HashMap<>();
        return helper(input, mem);

    }

    private List<Integer> helper(String input, Map<String, List<Integer>> mem) {
        if (mem.containsKey(input)) {
            return mem.get(input);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                String leftSubInput = input.substring(0, i);
                String rightSubInput = input.substring(i + 1);
                List<Integer> leftAns = helper(leftSubInput, mem);
                List<Integer> rightAns = helper(rightSubInput, mem);
                ans.addAll(operate(leftAns, rightAns, curChar));
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(input));
        }
        mem.put(input, ans);
        return ans;
    }

    private List<Integer> operate(List<Integer> list1, List<Integer> list2, char opt) {
        List<Integer> ans = new ArrayList<>();

        for (int num1 : list1) {
            for (int num2 : list2) {
                switch (opt) {
                case '+':
                    ans.add(num1 + num2);
                    break;
                case '-':
                    ans.add(num1 - num2);
                    break;
                case '*':
                    ans.add(num1 * num2);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        DifferentWaysToAddParentheses solu = new DifferentWaysToAddParentheses();
        List<Integer> ans = solu.diffWaysToCompute(input);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}