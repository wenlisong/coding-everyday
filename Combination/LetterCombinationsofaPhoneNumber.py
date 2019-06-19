# 17.LetterCombinationsofaPhoneNumber

# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

# A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

# Example:

# Input: "23"
# Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# Note:

# Althoughtheaboveanswer is in lexicographicalorder, youranswercouldbe in anyorderyouwant.

from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        number2letter = ["0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

        def backtrack(message, digits):
            res = []
            if len(digits) == 0:
                res.append(message)
            else:
                for letter in number2letter[int(digits[0])]:
                    res+=backtrack(message + letter, digits[1:])
            return res
        
        res = []
        if len(digits) > 0:
            res = backtrack("", digits)
        return res

if __name__ == "__main__":
    solu = Solution()
    res = solu.letterCombinations("23")
    print(res)