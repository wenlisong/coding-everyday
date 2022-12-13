import java.util.Arrays;

// 31. Next Permutation
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place and use only constant extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        NextPermutation solu = new NextPermutation();
        solu.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}