class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        //   (1)   (*2)   (*3)
        //   *4    (5)    (*6)
        //   *7    *8     (9)
        // 2 swaps with 4. 3 swaps with 7, 6 swaps with 8.
        // transpose: swap across the diagonal.
        for (int row = 0; row < matrix.length; row++) {
            // c = r means we only process upper triangle. Only flip it all once
            for (int col = row; col < matrix[row].length; col++) { // avoid double swap
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }   
        }
    }

    private void reverse(int[][] matrix) { // vertical flip
        // Even: Stop when pointers meet.
        //  1 1 1 -> 3 3 3
        //  2 2 2 -> 2 2 2
        //  3 3 3 -> 1 1 1
        // Odd: Stop when pointers cross.
        //  1 1 1 -> 4 4 4 
        //  2 2 2 -> 3 3 3 
        //  3 3 3 -> 2 2 2
        //  4 4 4 -> 1 1 1
        int n = matrix.length;
        for (int top = 0, bottom = n - 1; top < bottom; top++, bottom--) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
        }
    }
}
