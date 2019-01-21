# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# An input string is valid if:

# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        left_parentheses = ['(', '[', '{']
        right_parentheses = [')', ']', '}']
        stack = []
        for parenthesis in s:
            if parenthesis in left_parentheses:
                stack.append(parenthesis)
            elif parenthesis in right_parentheses:
                if stack:
                    top = stack.pop()
                    if top == '(' and parenthesis == ')':
                        continue
                    elif top == '[' and parenthesis == ']':
                        continue
                    elif top == '{' and parenthesis == '}':
                        continue
                    else:
                        return False
                else:
                    return False
            else:
                continue
        if stack:
            return False
        else:
            return True


def main():
    input = "([)]"
    # Output: false
    solu = Solution()
    print(solu.isValid(input))
    input="{[]}"
    # Output: true
    print(solu.isValid(input))


if __name__ == '__main__':
    main()
