class Solution {
    // private int islandSize = 0;
    public int islandPerimeter(int[][] grid) {
        int islandSize = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    islandSize = mapIsland(grid, row, col);
                }
            }
        }

        return islandSize;
    }

    private int mapIsland(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 1;
        if (grid[row][col] == 0) return 1;
        if (grid[row][col] == -1) return 0;

        grid[row][col] = -1;

        return
            mapIsland(grid, row + 1, col) +
            mapIsland(grid, row - 1, col) +
            mapIsland(grid, row, col + 1) +
            mapIsland(grid, row, col - 1);
    }
}