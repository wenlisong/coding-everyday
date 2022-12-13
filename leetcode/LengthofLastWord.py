# Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
# If the last word does not exist, return 0.
# Note: A word is defined as a character sequence consists of non-space characters only.


class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        last_word = 0
        pointer = -1
        while pointer > -len(s) and s[pointer] == ' ':
            pointer -= 1
        for i in range(pointer, -len(s)-1, -1):
            if s[i] == ' ':
                break
            else:
                last_word += 1
        return last_word

def main():
    s = "Hello World"
    # Output: 5
    solu = Solution()
    res = solu.lengthOfLastWord(s)
    print(res)


if __name__ == '__main__':
    main()
