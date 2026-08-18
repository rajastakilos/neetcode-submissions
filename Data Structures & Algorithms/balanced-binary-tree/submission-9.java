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
        if (root == null || !isB) return 0; // 0. !isB for early termination.
        // 1. left and right heights. 
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 2. check is Balanced.
        checkIsBalanced(leftHeight, rightHeight);
        // 3. Return 1 + larger side.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private void checkIsBalanced(int leftHeight, int rightHeight) {
        if (Math.abs(leftHeight - rightHeight) > 1) isB = false;
    }
}
