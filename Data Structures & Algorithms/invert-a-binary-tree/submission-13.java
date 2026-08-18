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

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll(); 
            TreeNode left = currentNode.left;
            TreeNode right = currentNode.right;
            currentNode.right = left;
            currentNode.left = right;
        
            if (left != null) nodeQueue.offer(left);
            if (right != null) nodeQueue.offer(right);
        }

        return root;
    }
}
