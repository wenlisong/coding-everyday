def validTicTacToe(board):
    """
    :type board: List[str]
    :rtype: bool
    """
    numX = 0
    numY = 0
    numboard = [[0 for col in range(3)] for row in range(3)]
    for i in range(3):
        for j in range(3):
            if board[i][j] == "X":
                numX += 1
                numboard[i][j] = 1
            elif board[i][j] == "Y":
                numY += 1
                numboard[i][j] = 0
            elif board[i][j] == " ":
                numboard[i][j] = -5
    if numX - numY < 0 or numX - numY > 1:
        return False

    r = []
    for i in range(8):
        r.append(0)
    for i in range(3):
        r[0] += numboard[0][i]
        r[1] += numboard[1][i]
        r[2] += numboard[2][i]
        r[3] += numboard[i][0]
        r[4] += numboard[i][1]
        r[5] += numboard[i][2]
        r[6] += numboard[i][i]
        r[7] += numboard[i][2 - i]
    print(numboard)
    print(r)
    for x in r:
        if x == 0 or x == 3:
            return True
    return False


x = ["XOX","O O","XOX"]
print(validTicTacToe(x))
