class Solution {
    public boolean isValidSudoku(char[][] board) {
        return areColumnsValid(board) && areRowsValid(board) && areGridsValid(board);
    }

    private boolean areColumnsValid(char[][] board) {
        Set<Character> seenSet = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.' && !seenSet.add(board[j][i])) return false;
            }
            seenSet.clear();
        }

        return true;
    }

    private boolean areRowsValid(char[][] board) {
        Set<Character> seenSet = new HashSet<>();
        for (char[] row : board) {
            for (char character : row) {
                if (character != '.' && !seenSet.add(character)) return false;
            }
            seenSet.clear();
        }

        return true;
    }

    private boolean areGridsValid(char[][] board) {
        Set<Character> seenSet = new HashSet<>();
        for (int box = 0; box < 9; box++) {
            seenSet.clear();
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;

            for (int k = 0; k < 9; k++) {
                int r = startRow + (k / 3);
                int c = startCol + (k % 3);
                if (board[r][c] != '.' && !seenSet.add(board[r][c])) return false;
            }
        }

        return true;
    }
}
