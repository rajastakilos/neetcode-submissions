class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // X X B
        // X X B
        // X X B Note: Our conceptual column is B's. We move within it by changing rows.
        int top = 0, bottom = matrix.length - 1;
        // B B B Note: Our conceptual row is B's. We move within it by changing columns. 
        // X X X
        // X X X
        int left = 0, right = matrix[0].length - 1;
        // row index → moves top to bottom
        // column index → moves left to right
        while (top <= bottom && left <= right) {
            // top
            // B B B 
            // X X X
            // X X X
            for (int col = left; col <= right; col++) result.add(matrix[top][col]);
            top++;
            // right 
            // X X B 
            // X X B
            // X X B
            for (int row = top; row <= bottom; row++) result.add(matrix[row][right]);
            right--;
            // traverse bottom if a row still remains.
            if (top <= bottom) {
                for (int col = right; col >= left; col--) result.add(matrix[bottom][col]);
                bottom--;
            }
            // traverse left if a column still remains
            if (left <= right) {
                for (int row = bottom; row >= top; row--) result.add(matrix[row][left]);
                left++;
            }
        }

        return result;
    }
}
