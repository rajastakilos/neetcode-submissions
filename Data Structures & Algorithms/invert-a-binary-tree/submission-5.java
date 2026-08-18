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

// Note: Invert binary tree: At every node swap left child and right child. 

//  Binary Tree: 
    // 1. Each node has at most two children (L and R)
    // 2. No ordering by default.
// BST:
    // 1. Values in L node are less than Node
    // 2. Values in R node are greater than Node

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            TreeNode currentRight = node.right;
            TreeNode currentLeft = node.left;
            node.right = currentLeft;
            node.left = currentRight;

            if (currentRight != null) treeNodeQueue.offer(currentRight);
            if (currentLeft != null) treeNodeQueue.offer(currentLeft);
        }   

        return root;  
    }
}
// Invariant: Every node that is dequeued must have left and right nodes swapped. 
// Time: O(n). Each node is processed once.
// Space:
    // Iterative (BFS queue): ✅ O(w) (max width).
        // Balanced tree: w ≈ n/2 ⇒ worst-case O(n)
        // Skewed tree: w = 1 ⇒ O(1)

    // Recursive (DFS call stack): it’s O(h), not always O(log n).
        // Balanced tree: h = O(log n) ✅
        // Skewed tree (linked list): h = O(n) ⇒ worst-case O(n) (and practical stack overflow risk)

// Skewed Tree (LL):
    // Recursive: Worst case we can blow the stack because we add 1,000,000 nodes.
    // Iterative: Worst case the maximum number of nodes it holds at once is the tree’s width.
        // That means O(1) width since it's a LL.
// Balanced Tree:
    //Iterative: In a balanced tree, BFS processes level by level. Right before it finishes a level, it has enqueued almost the entire next level.
        // O(n).
    // Recursive: recursion in a balanced tree uses stack depth equal to the height: O(log n).
