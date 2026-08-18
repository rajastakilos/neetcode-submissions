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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false; // No subtree if main tree is empty. 
        
        return sameTree(root, subRoot) || // Entire starting tree at root matches? OR
            isSubtree(root.left, subRoot) || // is subRoot on the left OR
            isSubtree(root.right, subRoot); // is subRoot on the right?
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return root.val == subRoot.val && 
            sameTree(root.right, subRoot.right) &&
            sameTree(root.left, subRoot.left);
    } 
}
