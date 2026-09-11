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
    
    public boolean isBalanced(TreeNode root) {
        boolean[] isB = {true};
        dfs(root, isB);
        return isB[0];
    }

    private int dfs(TreeNode node, boolean[] isB) {
        if (node == null || isB[0] == false) return 0;

        int leftHeight = dfs(node.left, isB);
        int rightHeight = dfs(node.right, isB);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isB[0] = false;
        }

        return 1 + Math.max(rightHeight, leftHeight);
    }
}
