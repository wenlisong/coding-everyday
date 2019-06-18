# 10.RegularExpressionMatching
# Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

# '.' Matches any single character.
# '*' Matches zero or more of the preceding element.
# The matching should cover the entire input string (not partial).

# Note:

# s could be empty and contains only lowercase letters a-z.
# p could be empty and contains only lowercase letters a-z, and characters like . or *.
# Example 1:

# Input:
# s = "aa"
# p = "a"
# Output: false
# Explanation: "a" does not match the entire string "aa".
# Example 2:

# Input:
# s = "aa"
# p = "a*"
# Output: true
# Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
# Example 3:

# Input:
# s = "ab"
# p = ".*"
# Output: true
# Explanation: ".*" means "zero or more (*) of any character (.)".
# Example 4:

# Input:
# s = "aab"
# p = "c*a*b"
# Output: true
# Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
# Example 5:

# Input:
# s = "mississippi"
# p = "mis*is*p*."
# Output: false

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s) + 1, len(p) + 1
        dp = [[False] * n for _ in range(m)]
        dp[0][0] = True
        
        for j in range(1, n):
            if p[j - 1] == '*' and dp[0][j - 2]:
                dp[0][j] = True
        for i in range(1, m):
            for j in range(1, n):
                if (p[j - 1] == s[i - 1] or p[j - 1] == '.') and dp[i - 1][j - 1]:
                    dp[i][j] = True
                elif p[j - 1] == '*':
                    if dp[i][j - 2]:
                        dp[i][j] = True
                    elif p[j - 2] == s[i - 1] or p[j - 2] == '.':
                        if dp[i-1][j]:
                            dp[i][j] = True
        return dp[-1][-1]
                    

if __name__ == "__main__":
    solu = Solution()
    res = solu.isMatch("aa", "a*")
            
