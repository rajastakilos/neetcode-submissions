class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char number = board[row][col];

                if (number != '.') {
                    String rowKey = number + "row" + row;
                    String colKey = number + "col" + col;
                    String squareKey = number + "square" + (row/3) + (col/3);

                    if (!seen.add(rowKey) || 
                        !seen.add(colKey) || 
                        !seen.add(squareKey)) return false;
                }
            }
        }



        return true;
    }
}
