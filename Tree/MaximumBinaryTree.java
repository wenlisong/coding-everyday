// 654. Maximum Binary Tree

// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
// Construct the maximum tree by the given array and output the root node of this tree.

// Example 1:
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:

//       6
//     /   \
//    3     5
//     \    / 
//      2  0   
//        \
//         1

class MaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recusion 2 ms	38.5 MB
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIdx = max(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = helper(nums, start, maxIdx);
        root.right = helper(nums, maxIdx + 1, end);
        return root;
    }

    private int max(int[] nums, int left, int right) {
        int max = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
