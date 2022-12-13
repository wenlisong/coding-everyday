# -*- coding:utf-8 -*-
# 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
# 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
class Solution:
    def Permutation(self, ss):
        # write code here
        res = []
        if len(ss) < 1:
            return res
        elif len(ss)==1:
            res.append(ss)
        else:
            other_permutation = self.Permutation(ss[1:])
            for s in other_permutation:
                res.extend(self.insertCharToString(ss[0], s))
        res = list(set(res))
        res = sorted(res)
        return res

    def insertCharToString(self, ch, s):
        res = []
        for i in range(len(s)+1):
            res.append(s[:i]+ch+s[i:])
        return res
            

def main():
    ss = 'aa'
    solu = Solution()
    res = solu.Permutation(ss)
    print(res)

if __name__ == "__main__":
    main()
