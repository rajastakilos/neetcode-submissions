class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length]; // Every int default to 0. 000000000 (lowest 9 bits)
        int[] cols = new int[board[0].length]; // Before anything, each row mask = all bits OFF.
        int[][] boxes = new int[3][3];
        // (0,0) (0,1) (0,2)
        // (1,0) (1,1) (1,2)
        // (2,0) (2,1) (2,2)

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                
                int val = board[row][col] - '1'; // Coerce char to int. 
                int bit = 1 << val; // BUILD MASK. Create a number with only the val-th bit ON
                // 1        = 000000001 // Key: Create not flip. Flip would be ^. Note: SHIFTS integer by val.
                // 1 << 4   = 000010000: 5th bit is ON (0 index);
                
                // Ex. 5: 000010000 & 000010000 == 1. False 
                // Ex. 5. 000010000 & 000000001 == 0. True
                if ((rows[row] & bit) != 0) return false; // & is the check.
                if ((cols[col] & bit) != 0) return false;
                if ((boxes[row / 3][col / 3] & bit) != 0) return false;

                rows[row]  |= bit; // |: Turn / Force ON this bit in the mask permanently. 
                cols[col]  |= bit; // Create not Flip.
                boxes[row / 3][col / 3] |= bit;
            }
        }

        return true;
    }
}

// << shift this 

// Bitwise AND &: A bit is ON in the result only if both inputs have it ON
// 1 & 1 = 1
// 1 & 0 = 0
// 0 & 1 = 0
// 0 & 0 = 0

// 5  = 0101
// 3  = 0011
// -----------
// &  = 0001  → 1


// REMEMBER: We aren't creating 1-9. We are taking 000000000 (0) and setting bits 0-8
// Using each bit as a boolean flag. 
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