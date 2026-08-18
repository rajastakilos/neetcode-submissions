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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()) {
            int currentLevelSize = nodeQueue.size();
            boolean isRightMostNodeFound = false;

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();

                if (!isRightMostNodeFound) {
                    result.add(currentNode.val);
                    isRightMostNodeFound = true;
                }

                if (currentNode.right != null) nodeQueue.offer(currentNode.right);
                if (currentNode.left != null) nodeQueue.offer(currentNode.left);
            }
        }

        return result;
    }
}

// Time: O(n). We touch each node at most once.
// Space: O(n - y)
    // currentLevelSize: O(w) at worst. We store at most the width of the tree per iteration.
    // result Our result contains the number of nodes n - y where y is all nodes that aren't right most.
