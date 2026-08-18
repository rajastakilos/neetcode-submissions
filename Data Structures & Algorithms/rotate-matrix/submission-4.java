class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        // transpose: swap across the diagonal.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) { // avoid double swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
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
