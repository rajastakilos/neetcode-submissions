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
    private int preIndex = 0;
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return buildSubtree(0, this.inorder.length - 1);
    }

    private TreeNode buildSubtree(int left, int right) {
        if (left > right) return null;

        int val = this.preorder[preIndex++];

        int mid = -1; // Defensive detail. 
        for (int i = left; i <= right; i++) {
            if (this.inorder[i] == val) { 
                mid = i; 
                break;
            }
        }

        TreeNode node = new TreeNode(val);
        node.left = buildSubtree(left, mid - 1);
        node.right = buildSubtree(mid + 1, right);

        return node;
    }
}
// Invariant:
// Time: O(n^2). We loop through both preorder and inorder. Each is a linear walk.
// Space: O(n). We build a new Tree from values in both arrays.
