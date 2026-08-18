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
// “An integer is just 32 boolean flags packed together.”
// Time Improvement:
// It uses constant-time bit operations (&, |) instead of array/set lookups
// These are CPU-level operations, so they’re extremely fast and avoid extra indirection

// Space Improvement:
// It compresses 9 boolean values into a single integer (32 bits)
// So instead of storing multiple arrays or sets, we store everything in a few integers.

// “Bitmasking is slightly more efficient because it uses constant-time bit operations 
// instead of array or set lookups, and it compresses multiple boolean states into a single integer. 
// The main benefit here is cleaner state representation rather than asymptotic improvement.”