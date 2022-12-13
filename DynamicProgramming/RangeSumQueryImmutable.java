// 303. Range Sum Query - Immutable
// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3

// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function.

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
class RangeSumQueryImmutable {
    // 244ms 59.6 MB
    private class NumArray1 {
        private int[] sum;

        public NumArray1(int[] nums) {
            sum = nums;
        }

        public int sumRange(int i, int j) {
            int ans = 0;
            for (; i <= j; i++) {
                ans += sum[i];
            }
            return ans;
        }

    }

    // 50 ms 43 MB
    private class NumArray2 {
        private int[] sum;

        public NumArray2(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }

    }
}