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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p!= null && q == null) return false;

        Queue<TreeNode> pNodeQueue = new ArrayDeque<>();
        pNodeQueue.offer(p);
        Queue<TreeNode> qNodeQueue = new ArrayDeque<>();
        qNodeQueue.offer(q);

        while (!pNodeQueue.isEmpty() && !qNodeQueue.isEmpty()) {
            TreeNode pNode = pNodeQueue.poll();
            TreeNode qNode = qNodeQueue.poll();

            if (pNode.val != qNode.val) return false;
            if (pNode.right != null && qNode.right == null) return false;
            if (pNode.right == null && qNode.right != null) return false;
            if (pNode.right != null && qNode.right != null) {
                if (pNode.right.val != qNode.right.val) return false;
            }

            if (pNode.left != null && qNode.left == null) return false;
            if (pNode.left == null && qNode.left != null) return false;
            if (pNode.left != null && qNode.left != null) {
                if (pNode.left.val != qNode.left.val) return false;
            }

            if (pNode.right != null) pNodeQueue.offer(pNode.right);
            if (pNode.left != null) pNodeQueue.offer(pNode.left);

            if (qNode.right != null) qNodeQueue.offer(qNode.right);
            if (qNode.left != null) qNodeQueue.offer(qNode.left);
        }


        return pNodeQueue.isEmpty() && qNodeQueue.isEmpty();
    }
}
// Time: O(p + q) where m is the number of nodes in p and q is the number of nodes in q.
// Space: O(width p + width q). Worst case we store up to the width of both trees in both queues. 
