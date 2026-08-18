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
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (true) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if (stack.isEmpty()) break;

            if (--k == 0) {
                return stack.pop().val;
            } else {
                curr = stack.pop().right;
            }


        }

        return -1;
    }
}
