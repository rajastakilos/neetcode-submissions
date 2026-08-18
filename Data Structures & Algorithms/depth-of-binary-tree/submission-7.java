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

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.offer(root); // BFS so use a queue.
        int maxDepth = 0;

        while (!nodeStack.isEmpty()) {
            int stackSize = nodeStack.size();

            for (int i = 0; i < stackSize; i++) {
                TreeNode currentNode = nodeStack.poll();
                if (currentNode.right != null) nodeStack.offer(currentNode.right);
                if (currentNode.left != null) nodeStack.offer(currentNode.left);
            }
            
            maxDepth++;
        }

        return maxDepth;
    }
}
