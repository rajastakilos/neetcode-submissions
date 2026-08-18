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
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1; // So we are accounting for edges and not nodes.

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        int throughThisNode = leftHeight + rightHeight + 2; // 2 for the edges directly connected to the parent.
        maxDiameter = Math.max(maxDiameter, throughThisNode);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
