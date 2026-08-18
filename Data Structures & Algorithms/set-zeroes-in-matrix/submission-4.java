class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHas0 = false;
        boolean firstColHas0 = false;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) { firstColHas0 = true; break; }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) { firstRowHas0 = true; break; }
        }

        // Mark which rows and columsn to zero out.
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                boolean isRowMarked = matrix[row][0] == 0;
                boolean isColMarked = matrix[0][col] == 0;

                if (isRowMarked || isColMarked) matrix[row][col] = 0;
            }
        }

        if (firstRowHas0) {
            for (int col = 0; col < matrix[0].length; col++) matrix[0][col] = 0;
        }

        if (firstColHas0) {
            for (int row = 0; row < matrix.length; row++) matrix[row][0] = 0;
        }
    }
}
