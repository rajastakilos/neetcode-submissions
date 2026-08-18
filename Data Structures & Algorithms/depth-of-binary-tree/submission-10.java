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

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root); // BFS so use a queue.
        int maxDepth = 0;

        while (!nodeQueue.isEmpty()) {
            int stackSize = nodeQueue.size();

            for (int i = 0; i < stackSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                if (currentNode.right != null) nodeQueue.offer(currentNode.right);
                if (currentNode.left != null) nodeQueue.offer(currentNode.left);
            }
            
            maxDepth++;
        }

        return maxDepth;
    }
}
