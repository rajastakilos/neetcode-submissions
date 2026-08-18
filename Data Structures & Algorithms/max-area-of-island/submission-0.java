class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxAreaOfLargestIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int mappedArea = mapIsland(grid, i, j, 0);
                    maxAreaOfLargestIsland = Math.max(mappedArea, maxAreaOfLargestIsland);
                }

            }
        }

        return maxAreaOfLargestIsland;
    }

    private int mapIsland(int[][] grid, int i, int j, int count) {
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            count++;
        } else {
            return count;
        }

        // Up
        if (i - 1 >= 0) count = mapIsland(grid, i - 1, j, count);
        // Down
        if (i + 1 < grid.length) count = mapIsland(grid, i + 1, j, count);
        // Left
        if (j - 1 >= 0) count = mapIsland(grid, i, j - 1, count);
        // Right
        if (j + 1 < grid[0].length) count = mapIsland(grid, i, j + 1, count);

        return count;
    }
}
