class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] cols = new int[board[0].length];
        int[][] boxes = new int[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                
                int val = board[row][col] - '1'; // ASCII value
                // 1        = 000000001
                // 1 << 4   = 000010000: 5th bit is ON.
                int bit = 1 << val; // Give me an example.

                if ((rows[row]  & bit) != 0) return false; // & is the check.
                if ((cols[col]  & bit) != 0) return false;
                if ((boxes[row / 3][col / 3] & bit) != 0) return false;

                rows[row]  |= bit; // Turn ON this bit in the mask
                cols[col]  |= bit; // | is the add
                boxes[row / 3][col / 3] |= bit;
            }
        }

        return true;
    }
}
