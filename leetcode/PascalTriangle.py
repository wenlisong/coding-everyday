# Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        pascaltriangle = [[1] * (i + 1) for i in range(numRows)]
        for i in range(2,numRows):
            for j in range(1,i):
                pascaltriangle[i][j]= pascaltriangle[i - 1][j - 1] + pascaltriangle[i - 1][j]
        return pascaltriangle
            
def main():
    n = 5
    solu = Solution()
    res=solu.generate(n)
    print(res)

if __name__ == '__main__':
    main()