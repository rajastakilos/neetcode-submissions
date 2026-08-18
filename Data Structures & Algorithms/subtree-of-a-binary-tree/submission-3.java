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
        Queue<TreeNode> generalNodeQueue = new ArrayDeque<>();
        generalNodeQueue.offer(root);

        while (!generalNodeQueue.isEmpty()) {
            TreeNode currentNode = generalNodeQueue.poll();

            if (currentNode.val == subRoot.val) {
                boolean doesCandidateMatchSubRoot = areTreesSame(currentNode, subRoot);
                if (doesCandidateMatchSubRoot) return true;
            }

            if (currentNode.right != null) generalNodeQueue.offer(currentNode.right);
            if (currentNode.left != null) generalNodeQueue.offer(currentNode.left);
        }

        return false;
    }

    private boolean areTreesSame(TreeNode candidateNode, TreeNode subTreeNode) {
        // I like two queues for clarity. We always know where the node came from. 
        // Plus have an extra queue doesn't matter for space big o since we are checking nodes
        // two at a time whether from one queue or two? We do create an extra space in memory for the extra collection though. 
        Queue<TreeNode> candidateQueue = new ArrayDeque<>();
        Queue<TreeNode> subTreeQueue = new ArrayDeque<>();
        candidateQueue.offer(candidateNode);
        subTreeQueue.offer(subTreeNode);

        while (!candidateQueue.isEmpty() && !subTreeQueue.isEmpty()) { // Need both? When would either have a remainder?
            TreeNode currentNode = candidateQueue.poll();
            TreeNode currentSubTreeNode = subTreeQueue.poll();

            if (currentNode.val != currentSubTreeNode.val) return false;

            // Can these 4 checks be condensed?
            if ((currentNode.right == null) != (currentSubTreeNode.right == null)) return false;
            if ((currentNode.left == null) != (currentSubTreeNode.left == null)) return false;

            if (currentSubTreeNode.right != null && currentNode.right != null) {
                subTreeQueue.offer(currentSubTreeNode.right);
                candidateQueue.offer(currentNode.right);
            }

            if (currentSubTreeNode.left != null && currentNode.left != null) {
                subTreeQueue.offer(currentSubTreeNode.left);
                candidateQueue.offer(currentNode.left);
            }
        }

        return true;
    }
}

// Time: O(n x m). In the worst case we must check every single node n in the input tree against each node m in the subTree.
// Space: O(w(n) + w(m)). We have three queues. In each queue the worst case is that we store the maximum width of a tree
    // in the queue at any given moment. w(n) represents the width of the input tree. w(m) represents the width of the subTree.