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
        dfsBalanceCheck(root);
        return this.isBalanced;
    }

    private int dfsBalanceCheck(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsBalanceCheck(node.left);
        int rightHeight = dfsBalanceCheck(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) this.isBalanced = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
// Time: O(n). We must check every node in the tree.
// Space: O(h). Recursion stack contains the height of the three at any given time.

// dfs(1)
//  ├─ dfs(2)
//  │   ├─ dfs(4)
//  │   │   ├─ dfs(null) → 0
//  │   │   └─ dfs(null) → 0
//  │   └─ dfs(5)
//  │       ├─ dfs(null) → 0
//  │       └─ dfs(null) → 0
//  └─ dfs(3)
//      ├─ dfs(null) → 0
//      └─ dfs(null) → 0
