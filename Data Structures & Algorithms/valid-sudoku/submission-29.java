class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9]; // Default: 000000000
        int[] cols = new int[9];
        int[][] boxes = new int[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                int val = board[row][col] - '1'; // 1 indexed. Ex. 4
                int bit = 1 << val; // 1 << 4 Flips 5th bit: 000010000

                if ((rows[row] & bit) != 0) return false; // 000010000 vs. 000010000 means a duplicate.
                if ((cols[col] & bit) != 0) return false;
                if ((boxes[row / 3][col /3] & bit) != 0) return false;

                rows[row] |= bit; // Flip 000000000 to 000010000
                cols[col] |= bit;
                boxes[row / 3][col / 3] |= bit;
            }
        }

        return true;
    }
}
