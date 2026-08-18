class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int matrixMid = getMatrixMid(matrix, mid);

            if (target < matrixMid) {
                right = mid - 1;
            } else if (target > matrixMid) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int getMatrixMid(int[][] matrix, int num) {
        int row = num / matrix[0].length;
        int col = num % matrix[0].length;

        return matrix[row][col];
    }
}
