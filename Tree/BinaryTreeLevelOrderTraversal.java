import java.util.ArrayList;
import java.util.List;

// 102. Binary Tree Level Order Traversal

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS 1 ms 36.5 MB
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> curLevel = new ArrayList<>(), nextLevel = new ArrayList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            List<Integer> levelAns = new ArrayList<>();

            for (TreeNode node : curLevel) {
                levelAns.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            ans.add(levelAns);
            List<TreeNode> tmp = curLevel;
            curLevel = nextLevel;
            nextLevel = tmp;
            nextLevel.clear();
        }
        return ans;
    }

    // DFS Recusion 1 ms	36.4 MB
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 1, ans);
        return ans;
    }

    private void helper(TreeNode root, int height, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() < height) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height - 1).add(root.val);
        helper(root.left, height + 1, ans);
        helper(root.right, height + 1, ans);
    }
}