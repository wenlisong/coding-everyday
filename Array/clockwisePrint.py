# coding=utf-8
# 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
# 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
# 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
class Solution:
    # matrix类型为二维列表，需要返回列表
    def printMatrix(self, matrix):
        result = []
        rows = len(matrix)
        cols = len(matrix[0])
        start = 0 # start from (0,0) to (i,i)
        while start < (rows + 1) // 2 and start < (cols + 1) // 2:
            result.extend(self.circlePrint(matrix, rows, cols, start))
            start +=1
        return result
        
    def circlePrint(self, matrix, rows, cols, start):
        res = []
        i = start
        while i < cols - start:
            res.append(matrix[start][i])
            i += 1
        i = start + 1
        while i < rows - start:
            res.append(matrix[i][cols - 1 - start])
            i += 1
        
        if rows - 1 - start > start:
            i = cols - 2 - start
            while i >= start:
                res.append(matrix[rows - 1 - start][i])
                i -= 1
        if start < cols - 1 - start:
            i = rows - 2 - start
            while i >= start+1:
                res.append(matrix[i][start])
                i -= 1
        return res

def main():
    arr = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
    # arr = [[1]]
    solu = Solution()
    res = solu.printMatrix(arr)
    for e in res:
        print(e)
if __name__ == "__main__":
    main()