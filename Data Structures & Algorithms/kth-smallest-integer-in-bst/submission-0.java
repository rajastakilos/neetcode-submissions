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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(root);
        TreeNode current = root;

        while (!nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            TreeNode node = nodeStack.pop();
            k--;
            if (k == 0) return node.val;
            current = node.right;
        }
        return 0;
    }

    
}

// Note: If this wasn't a BST, just a binary tree, we'd need a max heap.
// For BST: In order traversal. 
