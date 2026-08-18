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
    public boolean isValidBST(TreeNode root) {
       return validate(root, -10000, 10000); 
    }

    private boolean validate(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (min >= node.val || max <= node.val) return false;

        return validate(node.left, min, node.val) &&
        validate(node.right, node.val, max); 
    }
}
