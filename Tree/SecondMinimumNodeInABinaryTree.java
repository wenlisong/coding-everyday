import java.util.LinkedList;
import java.util.Queue;

// 671. Second Minimum Node In a Binary Tree

// Given a non-empty special binary tree consisting of nodes with the non-negative value, 
// where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
// then this node's value is the smaller value among its two sub-nodes. More formally, 
// the property root.val = min(root.left.val, root.right.val) always holds.

// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

// If no such second minimum value exists, output -1 instead.

// Example 1:
// Input: 
//     2
//    / \
//   2   5
//      / \
//     5   7
// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.

// Example 2:
// Input: 
//     2
//    / \
//   2   2

// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest value.

class SecondMinimumNodeInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS 0 ms 34.3 MB
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min1 = root.val;
        int min2 = Integer.MAX_VALUE;
        boolean isFound = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > min1 && node.val <= min2) {
                min2 = node.val;
                isFound = true;
                continue;
            }
            if (node.left == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        if (isFound) {
            return min2;
        } else {
            return -1;
        }
    }

    // DFS 0 ms	34.3 MB
    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        int left = dfs(root.left, min);
        int right = dfs(root.right, min);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
}