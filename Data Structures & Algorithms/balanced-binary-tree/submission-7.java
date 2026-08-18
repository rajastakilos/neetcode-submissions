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
    private boolean isB = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        height(root);
        return isB;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        checkIsBalanced(leftHeight, rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private void checkIsBalanced(int leftHeight, int rightHeight) {
        if (Math.abs(leftHeight - rightHeight) > 1) isB = false;
    }
}
