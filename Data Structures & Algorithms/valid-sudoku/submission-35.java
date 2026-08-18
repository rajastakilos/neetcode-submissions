class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        int sqrt = (int) Math.sqrt(board.length);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                String rowKey = c + "row" + row;
                String colKey = c + "col" + col;
                String sqrKey = c + "row" + row/sqrt + "col" + col/sqrt;

                if (!seen.add(rowKey) ||
                    !seen.add(colKey) ||
                    !seen.add(sqrKey)) return false;
            }
        }

        return true;
    }
}
