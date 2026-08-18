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
    private String DELIMITER = "#";
    private String N = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append(N).append(DELIMITER);
            } else {
                sb.append(curr.val).append(DELIMITER);
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] values = data.split(DELIMITER);
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int childIndex = 1;
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();

            if (!values[childIndex].equals(N)) {
                parent.left = new TreeNode(Integer.valueOf(values[childIndex]));
                q.offer(parent.left);
            }
            childIndex++;

            if (!values[childIndex].equals(N)) {
                parent.right = new TreeNode(Integer.valueOf(values[childIndex]));
                q.offer(parent.right);
            }
            childIndex++;
        }
            

        return root;
    }
}
