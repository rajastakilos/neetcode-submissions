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
        return dfsValidate(root, -1001, 1001);
    }

    private boolean dfsValidate(TreeNode root, int leftLimit, int rightLimit) {
        if (root == null) return true;
        if (root.val >= rightLimit) return false;
        if (root.val <= leftLimit) return false;

        return 
            dfsValidate(root.left, leftLimit, root.val) &&
            dfsValidate(root.right, root.val, rightLimit);
    }
}
