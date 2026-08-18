class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        int n = board.length;
        int sqrt = (int) Math.sqrt(n);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char number = board[row][col];
                if (number == '.') continue;

                String rowKey = number + "row" + row;
                String colKey = number + "col" + col;
                String squareKey = number + "square" + (row/sqrt) + "-" + (col/sqrt);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(squareKey)) return false; 
            }
        }

        return true;
    }
}
