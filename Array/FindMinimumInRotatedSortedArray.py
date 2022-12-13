# -*- coding:utf-8 -*-
# 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
# 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
# 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
# NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        high = len(rotateArray) - 1
        if high < 0:
            return 0
        elif high == 0:
            return rotateArray[0]

        mid = high // 2
        if rotateArray[mid] < rotateArray[high]:
            res = self.minNumberInRotateArray(rotateArray[:mid+1])
        elif rotateArray[mid] > rotateArray[high]:
            res = self.minNumberInRotateArray(rotateArray[mid+1:])
        else:
            res = min(self.minNumberInRotateArray(rotateArray[:mid+1]), self.minNumberInRotateArray(rotateArray[mid+1:]))
        return res
def main():
    arr = [4956,4956,4957,4957,4958]
    solu = Solution()
    res = solu.minNumberInRotateArray(arr)
    print(res)
if __name__ == "__main__":
    main()