class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int total = rowLength * colLength;
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

    private int getValueFromMatrix(int number, int[][] matrix) {
        int row = number / matrix[0].length;
        int col = number % matrix[0].length;

        return matrix[row][col];
    }
}
