/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> visited = new HashMap<>();

        return clone(node, visited);
    }

    private Node clone(Node original, Map<Node, Node> visited) {
        if (visited.containsKey(original)) return visited.get(original);

        Node copy = new Node(original.val);
        visited.put(original, copy);

        for (Node neighbor : original.neighbors) {
            copy.neighbors.add(clone(neighbor, visited));
        }

        return copy;
    }
}