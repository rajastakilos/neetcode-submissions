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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return maxSum;

        calculateMaxPath(root);
        return maxSum;
    }

    private int calculateMaxPath(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(calculateMaxPath(root.left), 0);
        int rightSum = Math.max(calculateMaxPath(root.right), 0);

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        int leftVal = root.left == null || root.left.val <= 0 ? 0 : root.left.val;
        int rightVal = root.right == null || root.right.val <= 0 ? 0 : root.right.val;

        return root.val + Math.max(leftSum, rightSum);
    }
}
