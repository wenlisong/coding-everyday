import java.util.Arrays;

// 561. Array Partition I
// Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
// say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

// Example 1:
// Input: [1,4,3,2]
// Output: 4
// Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
// Note:

// n is a positive integer, which is in the range of [1, 10000].
// All the integers in the array will be in the range of [-10000, 10000].
class ArrayPartitionI {
    public int arrayPairSum1(int[] nums) {
        // O(nlogn)
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum2(int[] nums) {
        int num_range = 10000;
        int[] count = new int[2 * num_range + 1];
        for (int num : nums) {
            ++count[num + num_range];
        }

        int sum = 0;
        boolean first = true;
        int i = -num_range;
        while (i < num_range) {
            if (count[i + num_range] == 0) {
                i++;
                continue;
            }
            if (first) {
                sum += i;
                first = false;
            } else {
                first = true;
            }
            count[i + num_range]--;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartitionI solution = new ArrayPartitionI();
        int[] nums = { 1, 4, 3, 2 };
        int rst = solution.arrayPairSum2(nums);
        System.out.println(rst);
    }
}