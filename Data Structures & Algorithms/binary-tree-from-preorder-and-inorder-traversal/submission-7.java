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
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inLeft, int inRight) {
        // No nodes in this inorder range
        if (inLeft > inRight) return null;

        // Preorder gives us the root first
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder to split left vs right subtree
        int splitIndex = findIndex(inorder, rootValue, inLeft, inRight);

        // Build left subtree from inorder left side
        root.left = build(preorder, inorder, inLeft, splitIndex - 1);

        // Build right subtree from inorder right side
        root.right = build(preorder, inorder, splitIndex + 1, inRight);

        return root;
    }

    private int findIndex(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value) return i;
        }
        return -1; // problem guarantees valid input
    }
}
