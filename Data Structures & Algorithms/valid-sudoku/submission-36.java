class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                String rowKey = c + "row" + row;
                String colKey = c + "col" + col;
                String boxKey = c + "row" + row/3 + "col" + col/3;

                if (!seen.add(rowKey) ||
                    !seen.add(colKey) ||
                    !seen.add(boxKey)) return false;
            }
        }

        return true;
    }
}
