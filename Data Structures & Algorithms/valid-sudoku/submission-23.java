class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] cols = new int[board[0].length];
        int[] boxes = new int[board.length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                
                int val = board[row][col] - '1'; // why - 1?
                int bit = 1 << val; // Give me an example.
                int box = (row / 3) * 3 + (col / 3); // Explain the calculation.

                if ((rows[row] & bit) != 0) return false; // Show me an eample of what the code before != means
                if ((cols[col] & bit) != 0) return false;
                if ((boxes[box] & bit) != 0) return false;

                rows[row]  |= bit; // Explain what |= is doing
                cols[col]  |= bit;
                boxes[box] |= bit;
            }
        }

        return true;
    }
}
