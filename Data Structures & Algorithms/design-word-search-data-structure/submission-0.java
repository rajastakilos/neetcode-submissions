class WordDictionary {
    private final Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (curr.children[j] == null) curr.children[j] = new Node();    
            curr = curr.children[j];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return this.search(this.root, word, 0);
    }

    private boolean search(Node node, String word, int i) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord;

        char ch = word.charAt(i);
        if (ch == '.') {
            for (Node child: node.children) {
                if (child != null && search(child, word, i + 1) == true) return true; // TODORAJAS. Visualize.
            }
            return false;
        } else {
            int j = ch - 'a';
            return search(node.children[j], word, i + 1);
        }
    }

    private static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}
