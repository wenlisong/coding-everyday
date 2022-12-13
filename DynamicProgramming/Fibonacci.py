class Fibonacci:
    # recursion
    def solution1(self, n):
        if n == 1 or n == 2:
            return 1
        else:
            return self.solution1(n - 1) + self.solution1(n - 2)
    
    # memoize
    def solution2(self, n, memo):
        if memo[n]:
            return memo[n]
        if n == 1 or n == 2:
            res = 1
        else:
            res = self.solution2(n - 1, memo) + self.solution2(n - 2, memo)
        memo[n] = res
        return res
    # bottom up
    def solution3(self, n):
        if n == 1 or n == 2:
            return 1
        fibo = [None] * (n + 1)
        fibo[1] = fibo[2] = 1
        for i in range(3, n + 1):
            fibo[i] = fibo[i - 1] + fibo[i - 2]
        return fibo[n]


def main():
    import time
    nums = [5, 10, 20, 30, 31, 32, 33, 100, 500, 1000]
    for n in nums:
        print("n=%s:" %n)
        if n <= 33:
            fibo = Fibonacci()
            t0 = time.clock()
            result = fibo.solution1(n)
            t1 = time.clock()
            print('cost time: %s' % (t1 - t0))
        else:
            print('n is too large to compute!')
        try:
            t2 = time.clock()
            memo = [None] * (n+1)
            result = fibo.solution2(n, memo)
            t3 = time.clock()
            print('cost time: %s' % (t3 - t2))
        except RecursionError:
            print('RecursionError, n is too large!')
        try:
            t4 = time.clock()
            result = fibo.solution3(n)
            t5 = time.clock()
            print('cost time: %s' % (t5 - t4))
        except RecursionError:
            print('RecursionError, n is too large!')
        print('')


if __name__ == "__main__":
    main()