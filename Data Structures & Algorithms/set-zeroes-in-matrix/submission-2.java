class Solution {
    boolean firstColHasZero = false;
    boolean firstRowHasZero = false;

    public void setZeroes(int[][] matrix) {
        // 1) Scan and mark
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    // mark column
                    matrix[0][c] = 0;

                    // mark row / handle first row
                    if (r == 0) { // Why does r == 0 mean first row has a zero? That is just an index
                        firstRowHasZero = true;
                    } else {
                        matrix[r][0] = 0;
                    }

                    // handle first column
                    if (c == 0) firstColHasZero = true; // Why does c == 0 mean first col has a zero? That is just an index
                }
            }
        }

        // 2) Apply markers (skip first row/col)
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        // Note we do the last two last so we don't erase our markers 

        // 3) Handle first column // Why do we do this last?
        if (firstColHasZero) {
            for (int r = 0; r < matrix.length; r++) matrix[r][0] = 0;
        }

        // 4) Handle first row // Why do we do this last?
        if (firstRowHasZero) {
            for (int c = 0; c < matrix[0].length; c++) matrix[0][c] = 0;
        }
    }
}