class Solution {
    private int maxIslandSize = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxIslandSize = Math.max(maxIslandSize, getIslandSize(row, col, grid));
                }
            }
        }

        return maxIslandSize;
    }

    private int getIslandSize(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + 
            getIslandSize(row + 1, col, grid) +
            getIslandSize(row - 1, col, grid) +
            getIslandSize(row, col + 1, grid) +
            getIslandSize(row, col - 1, grid);
    }
}
