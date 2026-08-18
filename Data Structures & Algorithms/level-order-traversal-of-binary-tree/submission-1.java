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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int currentLevelSize = nodeQueue.size();
            List<Integer> valuesForLevel = new ArrayList<>();    
            
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                valuesForLevel.add(currentNode.val);

                if (currentNode.left != null) nodeQueue.offer(currentNode.left);    
                if (currentNode.right != null) nodeQueue.offer(currentNode.right);            
            }

            result.add(valuesForLevel);
        }

        return result;
    }
}
// Time: O(n). We touch each node once.
// Space: Dominant O(n). 
    // result: O(n) We create a result array that is a list of lists. It contains a list correspond to each level.
        // It contains a value for every node.
    // valuesForLevl: O(w). For every iteration it contains at most the width of the current level.
