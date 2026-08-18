class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int total = matrix.length * matrix[0].length;
        int left = 0;
        int right = total - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int midVal = getMid(matrix, mid); 

            if (midVal > target) {
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int getMid(int[][] matrix, int num) {
        int row = num / matrix[0].length;
        int col = num % matrix[0].length;

        return matrix[row][col]; 
    }
}
