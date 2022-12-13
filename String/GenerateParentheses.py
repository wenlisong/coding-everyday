# 22.GenerateParentheses
# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

# For example, given n = 3, a solution set is:

# [
#   "((()))",
#   "(()())",
#   "(())()",
#   "()(())",
#   "()()()"
# ]
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # recursion
        def generate(left, right):
            res = []
            if right == 0:
                res.append('')
            if left > 0:
                res.extend(['(' + substr for substr in generate(left - 1, right)])
            if left < right:
                res.extend([')' + substr for substr in generate(left, right - 1)])
            return res
        
        res = generate(n, n)
                
        return res

    def generateParenthesis2(self, n: int) -> List[str]:
        # backtracking
        res = []
        def generate(substr, left, right):
            if right == 0:
                res.append(substr)
                return
            if left > 0:
                generate(substr + '(', left - 1, right)
            if left < right:
                generate(substr + ')', left, right - 1)
        
        generate('', n, n)
        return res

if __name__ == "__main__":
    solu = Solution()
    n = 4
    res = solu.generateParenthesis(n)
    print(res)
    res2 = solu.generateParenthesis2(n)
    print(res2)
    print(res==res2)
            