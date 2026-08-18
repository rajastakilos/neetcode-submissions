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

        // int maxDepth = 1;
        // Deque<TreeNode> nodeStack = new ArrayDeque<>();
        // nodeStack.push(root);

        // while (nodeStack.isEmpty()) {
            // TreeNode currentNode = nodeStack.pop();
        return dfs(root, 0);
        // }

        // return maxDepth;
    }

    private int dfs(TreeNode node, int count) {
        if (node == null) return count;
        count++;

        return Math.max(
            dfs(node.right, count), 
            dfs(node.left, count)
        );
    }
}
