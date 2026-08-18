class PrefixTree {
    private final Node root = new Node();

    public PrefixTree() {}

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) 
                node.children[idx] = new Node();
                node = node.children[idx]; 
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }

        return true;
    }

    private static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}
