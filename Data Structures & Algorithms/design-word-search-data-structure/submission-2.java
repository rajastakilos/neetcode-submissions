class WordDictionary {
    private final Node root = new Node();

    public WordDictionary() {}

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Node();
            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return searchFrom(root, word, 0);
    }

    private boolean searchFrom(Node node, String word, int index) { // DFS
        if (node == null) return false;
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);

        if (c == '.') {
             for (Node child : node.children) {
                if (searchFrom(child, word, index + 1)) return true;
            }
        } else {
            return searchFrom(node.children[c - 'a'], word, index + 1); // Normal search

           
        }

        return false;
    }

    private static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}
