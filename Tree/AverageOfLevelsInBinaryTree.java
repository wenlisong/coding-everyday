import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 637. Average of Levels in Binary Tree

// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
// Example 1:
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
// Note:

// The range of node's value is in the range of 32-bit signed integer.

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class AverageOfLevelsInBinaryTree {
    // DFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        preorder(root, sum, count, 0);

        for (int i = 0; i < count.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    private void preorder(TreeNode root, List<Double> sum, List<Integer> count, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel >= count.size()) {
            sum.add(Double.valueOf(root.val));
            count.add(1);
        } else {
            sum.set(curLevel, sum.get(curLevel) + root.val);
            count.set(curLevel, count.get(curLevel) + 1);
        }
        curLevel++;
        preorder(root.left, sum, count, curLevel);
        preorder(root.right, sum, count, curLevel);
    }

    // BFS
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> rst = new ArrayList<>();
        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            long sum = 0;
            int count = 0;
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!curLevel.isEmpty()) {
                TreeNode node = curLevel.poll();
                sum += node.val;
                count++;
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            rst.add(Double.valueOf(sum) / count);
            curLevel = nextLevel;
        }
        return rst;
    }
}