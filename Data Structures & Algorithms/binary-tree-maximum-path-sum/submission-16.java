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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = Math.max(0, calculateMaxPathSum(node.left));
        int rightHeight = Math.max(0, calculateMaxPathSum(node.right));

        maxSum = Math.max(maxSum, node.val + leftHeight + rightHeight);

        return node.val + Math.max(leftHeight, rightHeight); 
    }
}
