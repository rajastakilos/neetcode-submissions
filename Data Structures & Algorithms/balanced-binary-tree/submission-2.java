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
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfsBalanceCheck(root);
        return this.isBalanced;
    }

    private int dfsBalanceCheck(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsBalanceCheck(node.left);
        int rightHeight = dfsBalanceCheck(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) this.isBalanced = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
