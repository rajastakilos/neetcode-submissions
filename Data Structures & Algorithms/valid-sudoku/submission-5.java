class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char number = board[row][col];

                if (number != '.') {
                    String rowKey = number + "row" + row;
                    String colKey = number + "col" + col;
                    String squareKey = number + "square" + (row/3) + "-" + (col/3);
                    // Note: "-" prevents ambiguous string concatenation. 
                    // Meaning 1 - 23 and 12 -3. In 9x9 we are fine though.

                    if (!seen.add(rowKey) || 
                        !seen.add(colKey) || 
                        !seen.add(squareKey)) return false;
                }
            }
        }



        return true;
    }
}

// Rows 0, 1, 2 ÷ 3= 0 (The Top Band)
// Rows 3, 4, 5 ÷ 3= 1 (The Middle Band)
// Rows 6, 7, 8 ÷ 3= 2 (The Bottom Band)

// Cols 0, 1, 2 ÷ 3= 0 (The Left Stack)
// Cols 3, 4, 5 ÷ 3= 1 (The Center Stack)
// Cols 6, 7, 8 ÷ 3= 2 (The Right Stack)
