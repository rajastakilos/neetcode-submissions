class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int total = matrix.length * matrix[0].length;
        int left = 0;
        int right = total - 1;

        while (left <= right) {    
            int mid = left + (right - left) / 2;
            int midValue = getValueFromMatrix(mid, matrix);

            if (target == midValue) return true;

            if (target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    // number represents the index.
    private int getValueFromMatrix(int number, int[][] matrix) {
        int row = number / matrix[0].length; // Java rounds down for integer divison.
        int col = number % matrix[0].length; // 0 is first column, 1 is second, and so on.

        return matrix[row][col]; // like x, y.
    }
}
