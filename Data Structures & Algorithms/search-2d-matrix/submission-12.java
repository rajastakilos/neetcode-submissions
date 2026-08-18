class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int total = matrix.length * matrix[0].length; // KEY
        int left = 0;
        int right = total - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = getMidValue(matrix, mid);

            if (midValue > target) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int getMidValue(int[][] matrix, int num) {
        int row = num / matrix[0].length;
        int col = num % matrix[0].length;

        return matrix[row][col];
    }
}
