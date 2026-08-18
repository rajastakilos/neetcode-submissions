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
    private String N = "N";
    private String D = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();

        Queue<TreeNode> queue = new LinkedList<>(); // Deque won't accept nulls.
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(N).append(D);
            } else {
                sb.append(String.valueOf(node.val)).append(D);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        
        String[] values = data.split(D);

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
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

// childIndex: stream of not-yet-consumed child entries

// Another way to see it

// Think of the serialized data as a conveyor belt:

// 1, 2, 3, 4, 6, 7, 8, 9, 10

// And the queue as a line of parents waiting to be assigned children.

// parent 1 walks up to the belt and takes the next two items: 2, 3
// parent 2 takes the next two: 4, 6
// parent 3 takes the next two: 7, 8
// parent 4 takes the next two: 9, 10

// Nobody cares where the parent itself originally appeared in the belt.
// The only thing that matters is parent order and next two child tokens.

// The invariant (lock this in)

// Every parent in the queue is waiting to consume exactly two tokens:

// one for left
// one for right

// That’s why the simple index += 2 pattern works.
