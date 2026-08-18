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
    private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = Math.max(0, dfs(node.left));
        int rightHeight = Math.max(0, dfs(node.right));

        maxPathSum = Math.max(maxPathSum, node.val + leftHeight + rightHeight);

        return node.val + Math.max(leftHeight, rightHeight);
    }
}
