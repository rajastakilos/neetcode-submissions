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

// Note: Invert binary tree: At every node swap left child and right child. 

//  Binary Tree: 
    // 1. Each node has at most two children (L and R)
    // 2. No ordering by default.
// BST:
    // 1. Values in L node are less than Node
    // 2. Values in R node are greater than Node

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            TreeNode currentRight = node.right;
            TreeNode currentLeft = node.left;
            if (currentRight != null) treeNodeQueue.offer(currentRight);
            if (currentLeft != null) treeNodeQueue.offer(currentLeft);

            node.right = currentLeft;
            node.left = currentRight;
        }   

        return root;  
    }
}
