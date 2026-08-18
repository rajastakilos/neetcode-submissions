class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] boxes = new int[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                int val = board[row][col] - '1';
                int bit = 1 << val;

                if ((rows[row] & bit) != 0) return false;
                if ((cols[col] & bit) != 0) return false;
                if ((boxes[row / 3][col /3] & bit) != 0) return false;

                rows[row] |= bit;
                cols[col] |= bit;
                boxes[row / 3][col / 3] |= bit;
            }
        }

        return true;
    }
}
