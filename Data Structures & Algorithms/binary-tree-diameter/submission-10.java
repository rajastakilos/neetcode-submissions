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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // if (root == null) return 0;

        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode node) {
        if (node == null) return 0;

        int left = calculateDiameter(node.left);
        int right = calculateDiameter(node.right);
        
        int longest = Math.max(left, right) + 1;
        
        diameter = Math.max(diameter, left + right);

        return longest;
    }
}
