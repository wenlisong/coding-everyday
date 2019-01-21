# Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
# Follow up:
# A straight forward solution using O(mn) space is probably a bad idea.
# A simple improvement uses O(m + n) space, but still not the best solution.
# Could you devise a constant space solution?


class Solution:
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not matrix:
            pass
        else:
            m = len(matrix)
            n = len(matrix[0])
            row_idx = set()
            col_idx = set()
            for i in range(m):
                for j in range(n):
                    if matrix[i][j] == 0:
                        row_idx.add(i)
                        col_idx.add(j)
            
            for i in row_idx:
                for j in range(n):
                    matrix[i][j] = 0

            for i in col_idx:
                for j in range(m):
                    matrix[j][i] = 0
        return matrix


def main():
    arr = [
        [0, 1, 2, 0],
        [3, 4, 5, 2],
        [1, 3, 1, 5]
    ]
    solu = Solution()
    res = solu.setZeroes(arr)
    print(res)


if __name__ == '__main__':
    main()
