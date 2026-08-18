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

        int inLeft = 0;
        int inRight = inorder.length - 1;

        return buildSubtree(inLeft, inRight);
    }

    private TreeNode buildSubtree(int left, int right) {
        if (left > right) return null;

        int val = this.preorder[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(val);

        int mid = -1;
        for (int i = left; i <= right; i++) {
            if (this.inorder[i] == val) {
                mid = i;
                break;
            }
        }

        TreeNode leftNode = buildSubtree(left, mid - 1);
        TreeNode rightNode = buildSubtree(mid + 1, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
// Invariant:
// Time: O(n). We loop through both preorder and inorder. Each is a linear walk.
// Space: O(n). We build a new Tree from values in both arrays.
