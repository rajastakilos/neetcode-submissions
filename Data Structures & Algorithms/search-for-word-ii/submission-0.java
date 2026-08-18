class Solution {    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

        char c = board[row][col];
        if (c == '#') return;

        TrieNode next = node.children[c - 'a'];
        if (next == null) return; // Current path is not a valid tree prefix.
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates.
        }

        board[row][col] = '#'; // mark visisted (aka sink the island)

        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        board[row][col] = c; // backtrack!
    }

    private static class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }

            curr.word = word;
        }

        return root;

    }
}
