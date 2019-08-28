// 461. Hamming Distance
// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
// Given two integers x and y, calculate the Hamming distance.

// Note:
// 0 ≤ x, y < 231.

// Example:
// Input: x = 1, y = 4
// Output: 2

// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑

// The above arrows point to positions where the corresponding bits are different.


class HammingDistance {
    public int hammingDistance(int x, int y) {
        int rst = 0;
        for (int i = 0; i < 31; i++) {
            if (x % 2 != y % 2) {
                rst++;
            }
            x /= 2;
            y /= 2;
        }
        return rst;
    }

    public int hammingDistance2(int x, int y) {
        int rst = 0;
        int xor = x ^ y;
        while (xor > 0) {
            if ((xor & 1) > 0) {
                rst++;
            }
            xor >>= 1;
        }
        return rst;
    }

    public int hammingDistance3(int x, int y) {
        int rst = 0;
        int xor = x ^ y;
        while (xor > 0) {
            rst += xor & 1;
            xor >>= 1;
        }
        return rst;
    }
}