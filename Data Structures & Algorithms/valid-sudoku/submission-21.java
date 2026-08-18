class Solution {
    public boolean isValidSudoku(char[][] board) {
         // First is 9 rows; Second is digit value as index;
        boolean[][] rows = new boolean[board.length][board.length + 1];
        boolean[][] cols = new boolean[board[0].length][board.length + 1];
        boolean[][] boxes = new boolean[board.length][board.length + 1];
        int sqrt = (int) Math.sqrt(board.length);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                int boxIndex = (row/3) * 3 + (col/3);
                if (rows[row][c - '0'] || 
                    cols[col][c - '0'] ||
                    boxes[boxIndex][c - '0']) return false;

                rows[row][c - '0'] = true;
                cols[col][c - '0'] = true;
                boxes[boxIndex][c - '0'] = true;
            }
        }

        return true;
    }
}
