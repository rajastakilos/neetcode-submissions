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
    boolean isB = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return isB;

        height(root);
        return isB;
    }

    private int height(TreeNode node) {
        if (node == null || isB == false) return 0;

        int left = height(node.left);
        int right = height(node.right);

        checkIsBalanced(left, right);

        return 1 + Math.max(left, right);
    }

    private void checkIsBalanced(int left, int right) {
        if (Math.abs(left - right) > 1) isB = false;
    }
}
