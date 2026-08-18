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
        if (root == null) return isBalanced;

        calculateTreeHeight(root);
        return isBalanced;
    }

    private int calculateTreeHeight(TreeNode node) {
        if (node == null) return 0;
        if (!isBalanced) return 0;

        int leftHeight = calculateTreeHeight(node.left);
        int rightHeight = calculateTreeHeight(node.right);

        checkIsBalanced(leftHeight, rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private void checkIsBalanced(int leftHeight, int rightHeight) {
        if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
    }

}
