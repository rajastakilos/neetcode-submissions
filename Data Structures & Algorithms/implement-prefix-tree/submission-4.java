class PrefixTree {
    private final Node root = new Node();

    public PrefixTree() {}

    // Insert = walk + create nodes if missing
    public void insert(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Node();
            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = traverse(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private Node traverse(String str) {
        Node node = root;

        for (char c : str.toCharArray()) {
            if (node.children[c - 'a'] == null) return null;
            node = node.children[c-'a'];
        }

        return node;
    }

    private static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}