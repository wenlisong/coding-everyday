# Count the number of prime numbers less than a non-negative number, n.

class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 0
        prime_list = [True for i in range(n)]
        prime_list[0] = prime_list[1] = False
        for i in range(2, n // 2 + 1):
            if prime_list[i]:
                prime_list[i*i:n:i] = [False for _ in range(len(prime_list[i*i:n:i]))]
        return sum(prime_list)