class WordDictionary {
    private final Node root = new Node();

    public WordDictionary() {}

    public void addWord(String word) {
        Node node = root;
        for (int i = 0 ; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
         }

         node.isWord = true;
    }

    public boolean search(String word) {
        return searchFrom(root, word, 0);
    }

    // “In the worst case with many wildcards, the search becomes exponential because each . 
    // branches to all 26 children. So time is O(26^d * n), where d is the number of wildcards. 
    // Without wildcards, it’s just O(n).”    
    private boolean searchFrom(Node node, String word, int index) {
        if (node == null) return false;
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if (c == '.') {
            for (Node child : node.children) {
                if (searchFrom(child, word, index + 1)) return true;
            }
        } else {
            return searchFrom(node.children[c - 'a'], word, index + 1);
        }

        return false;    
    }

    private static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}
