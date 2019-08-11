# coding=utf-8
"""
# Determine whether strings in a list can be connected end to end.
# This question is a variation of find all combination or deep search fisrt.
# Use backtrack.
"""
import sys


def main():
    str_arr = 'CAT TIGER RPC'.strip().split()
    # arr = sys.stdin.readline().strip().split()
    k = 0
    res = []
    def dfs(arr, idx):
        if len(arr) == idx:
            res.append(' '.join(arr))
        else:
            for i in range(idx, len(arr)):
                if idx == 0 or arr[idx-1][-1] == arr[i][0]:
                    arr[i], arr[idx] = arr[idx], arr[i]
                    dfs(arr, idx+1)
                    arr[i], arr[idx] = arr[idx], arr[i]
    dfs(str_arr, k)
    for item in res:
        if item[0] == item[-1]:
            print('true')
            return 
    print('false')

if __name__ == "__main__":
    main()
