class PrefixTree {
    private final Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) cur.children[j] = new Node();
            cur = cur.children[j];
        }
        cur.isWord = true;
        // TODORAJAS: Inserting existing word should just re-mark word as isTrue.
    }

    public boolean search(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) { 
                return false;
            } else {
                cur = cur.children[j];
            }
        }

        return cur.isWord; // Key idea: every char path must exist, and the final node must be a word end.
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (cur.children[j] == null) {
                return false;
            } else {
                cur = cur.children[j];
            }
        }

        return true;
    }

    private static class Node {
        private boolean isWord;
        private Node[] children = new Node[26];
    }
}
// Time
    // Insert: O(L)
    // Search: O(L)
    // StartsWith: O(L)
// Space: O(total characters inserted)
    // (Worst case: every node has up to 26 pointers)