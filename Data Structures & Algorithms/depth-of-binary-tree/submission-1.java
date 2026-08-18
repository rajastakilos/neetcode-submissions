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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int count) {
        if (node == null) return count;
        // count++;

        return Math.max(
            1 + dfs(node.right, count), 
            1 + dfs(node.left, count)
        );
    }
}
