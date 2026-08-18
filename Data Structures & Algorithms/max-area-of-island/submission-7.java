class Solution {
    private int maxAreaOfIsland = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxAreaOfIsland = Math.max(maxAreaOfIsland, calculateIslandArea(grid, row, col));
                }
            }
        }

        return maxAreaOfIsland;
    }

    private int calculateIslandArea(int[][] grid, int row, int col) {
        if (row < 0 || 
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1 +
            calculateIslandArea(grid, row + 1, col) +
            calculateIslandArea(grid, row - 1, col) +
            calculateIslandArea(grid, row, col + 1) +
            calculateIslandArea(grid, row, col - 1);
    }
}
