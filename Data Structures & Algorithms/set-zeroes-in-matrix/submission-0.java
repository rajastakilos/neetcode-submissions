class Solution {
    boolean firstColHasZero = false;
    boolean firstRowHasZero = false;

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1) Scan and mark
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {

                    // mark column
                    matrix[0][c] = 0;

                    // mark row / handle first row
                    if (r == 0) {
                        firstRowHasZero = true;
                    } else {
                        matrix[r][0] = 0;
                    }

                    // handle first column
                    if (c == 0) {
                        firstColHasZero = true;
                    }
                }
            }
        }

        // 2) Apply markers (skip first row/col)
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // 3) Handle first column
        if (firstColHasZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }

        // 4) Handle first row
        if (firstRowHasZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}