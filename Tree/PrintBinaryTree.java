import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 655. Print Binary Tree

// Print a binary tree in an mn 2D string array following these rules:

// The row number m should be equal to the height of the given binary tree.
// The column number n should always be an odd number.
// The root node's value (in string format) should be put in the exactly middle of the first row it can be put. 
// The column and the row where the root node belongs will separate the rest space into two parts 
// (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part 
// and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. 
// Even if one subtree is none while the other is not, 
// you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. 
// However, if two subtrees are none, then you don't need to leave space for both of them.
// Each unused space should contain an empty string "".
// Print the subtrees following the same rules.

// Example 1:
// Input:
//      1
//     /
//    2
// Output:
// [["", "1", ""],
//  ["2", "", ""]]

// Example 2:
// Input:
//      1
//     / \
//    2   3
//     \
//      4
// Output:
// [["", "", "", "1", "", "", ""],
//  ["", "2", "", "", "", "3", ""],
//  ["", "", "4", "", "", "", ""]]

// Example 3:
// Input:
//       1
//      / \
//     2   5
//    / 
//   3 
//  / 
// 4 
// Output:
// [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
//  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
//  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
//  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// Note: The height of binary tree is in the range of [1, 10].
// Definition for a binary tree node.
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeightOfTree(root);
        int width = (1 << height) - 1; // 2^height - 1
        String[][] tree = new String[height][width];
        for (String[] row : tree)
            Arrays.fill(row, "");
        
        fill(root, tree, 0, 0, width - 1);

        List<List<String>> ans = new ArrayList<>();
        for (String[] row : tree) {
            ans.add(Arrays.asList(row));
        }
        return ans;
    }

    private int getHeightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }

    private void fill(TreeNode root, String[][] tree, int height, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        tree[height][mid] = Integer.toString(root.val);
        fill(root.left, tree, height + 1, left, mid - 1);
        fill(root.right, tree, height + 1, mid + 1, right);
    }
}