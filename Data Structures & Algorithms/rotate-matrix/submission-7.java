class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        // transpose: swap across the diagonal.
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[row].length; col++) { // avoid double swap
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }   
        }
    }

    private void reverse(int[][] matrix) { // vertical flip
        int n = matrix.length;
        for (int top = 0, bottom = n - 1; top < bottom; top++, bottom--) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
        }
    }
}
