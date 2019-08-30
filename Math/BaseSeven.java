import com.sun.org.apache.xpath.internal.operations.And;

// 504. Base 7

// Given an integer, return its base 7 string representation.

// Example 1:
// Input: 100
// Output: "202"

// Example 2:
// Input: -7
// Output: "-10"
// Note: The input will be in range of [-1e7, 1e7].

class BaseSeven {
    // 1 ms 34.2 MB
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb = sb.insert(0, num % 7);
            num /= 7;
        }
        if (isNegative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
    // 1 ms	34.5 MB
    public String convertToBase72(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        String ans = "";
        while (num > 0) {
            ans = num % 7 + ans;
            num /= 7;
        }
        if (isNegative) {
            ans = "-" + ans;
        }
        return ans;
    }
}