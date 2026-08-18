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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        getMaxDiameter(root);
        return maxDiameter;
    }

    private int getMaxDiameter(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getMaxDiameter(node.left);
        int rightHeight = getMaxDiameter(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
// Max Depth: one path downward
// Diameter: combine two downward paths at every node