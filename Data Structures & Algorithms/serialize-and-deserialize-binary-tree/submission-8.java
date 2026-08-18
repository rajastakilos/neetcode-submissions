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

public class Codec {
    private String D = "#";
    private String N = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(N).append(D);
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val).append(D);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        
        String[] values = data.split(D);
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int childIndex = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            if (!values[childIndex].equals(N)) {
                parent.left = new TreeNode(Integer.valueOf(values[childIndex]));
                queue.offer(parent.left);
            }
            childIndex++;

            if (!values[childIndex].equals(N)) {
                parent.right = new TreeNode(Integer.valueOf(values[childIndex]));
                queue.offer(parent.right);
            }
            childIndex++;
        }

        return root;

    }
}
