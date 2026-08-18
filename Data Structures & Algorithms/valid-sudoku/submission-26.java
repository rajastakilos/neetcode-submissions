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

// Bitwise AND &: A bit is ON in the result only if both inputs have it ON
// 1 & 1 = 1
// 1 & 0 = 0
// 0 & 1 = 0
// 0 & 0 = 0

// 5  = 0101
// 3  = 0011
// -----------
// &  = 0001  → 1

// False case
// Say a row already has a '5': rows[row] = 000010000
// Now another row has a '5': bit = 000010000
// Not a zero: duplicate. 
// 000010000
// &
// 000010000
// =
// 000010000  (≠ 0)

// True case:
// rows[row] = 000001000   (digit 4)
// bit       = 000010000   (digit 5)
// 000001000
// &
// 000010000
// =
// 000000000 (= 0)

// Note: See & as an intersection check. If no overlap: Good. Else: Duplicate.