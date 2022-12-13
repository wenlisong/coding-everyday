import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
// Given an array nums of n integers and an integer target, 
// are there elements a, b, c, and d in nums such that a + b + c + d = target? 
// Find all unique quadruplets in the array which gives the sum of target.

// Note:
// The solution set must not contain duplicate quadruplets.

// Example:
// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    public ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (index >= n) {
            return rst;
        }
        if (k == 2) {
            int i = index, j = n - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    rst.add(list);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < n - k + 1; i++) {
                ArrayList<List<Integer>> list = kSum(nums, target - nums[i], k - 1, i + 1);
                if (list != null) {
                    for (List<Integer> item : list) {
                        item.add(0, nums[i]);
                    }
                    rst.addAll(list);
                }
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        FourSum solu = new FourSum();
        List<List<Integer>> rst = solu.fourSum(nums, target);
        System.out.println(rst);
    }
}