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

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int queueSize = q.size(); // Key 1

            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = q.poll();
                if (i == 0) result.add(curr.val);
                if (curr.right != null) q.offer(curr.right); // Key 2: right before left.
                if (curr.left != null) q.offer(curr.left);
            }

        }

        return result;
    }
}
