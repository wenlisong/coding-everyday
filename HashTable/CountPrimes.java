import java.util.Arrays;

// 204. Count Primes

// Count the number of prime numbers less than a non-negative number, n.

// Example:
// Input: 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

class CountPrimes {
    // Time Limit Exceeded
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    // 10 ms 34.4 MB
    public int countPrimes2(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean isPrime : isPrimes) {
            if (isPrime) {
                count++;
            }
        }
        return count;
    }
}