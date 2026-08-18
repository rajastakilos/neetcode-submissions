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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll(); 
            TreeNode left = node.left;
            TreeNode right = node.right;
            // 1 Swap unconditionally.
            node.right = left;
            node.left = right;
            // 2. Queue conditionally
            if (left != null) q.offer(left);
            if (right != null) q.offer(right);
        }

        return root;
    }
}
