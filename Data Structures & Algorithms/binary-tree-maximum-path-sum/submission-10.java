/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxPathSum = Integer.MIN_VALUE; // Critical for negative values.
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(0, calculateMaxPathSum(node.left));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right));

        maxPathSum = Math.max(maxPathSum, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
