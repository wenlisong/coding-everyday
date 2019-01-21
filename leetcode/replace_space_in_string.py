class Solution:
    # s original string
    def replaceSpace(self, s):
        # write code here
        return s.replace(" ", "%20")


str = "hello world"
solu = Solution()
print(solu.replaceSpace(str))
