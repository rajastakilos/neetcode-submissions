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
        return dfsValidate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfsValidate (TreeNode node, long leftLimit, long rightLimit) { // TODORAJAS: int vs long.
        if (node == null) return true;

        if (node.val >= rightLimit) return false;
        if (node.val <= leftLimit) return false;

        return 
            dfsValidate(node.left, leftLimit, node.val) && 
            dfsValidate(node.right, node.val, rightLimit);
    }
}
