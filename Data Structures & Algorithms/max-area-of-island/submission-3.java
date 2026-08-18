class Solution {
    private int maxIslandSize = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currIslandSize = calculateIslandSizeAndCompareToCurrentMax(grid, i, j, 0);
                    maxIslandSize = Math.max(maxIslandSize, currIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int calculateIslandSizeAndCompareToCurrentMax(int[][] grid, int x, int y, int count) {
        if (grid[x][y] == 1) {
            count++;
            grid[x][y] = 0;
        } else {
            return count;
        }

        // Up
        if (x - 1 >= 0) count = calculateIslandSizeAndCompareToCurrentMax(grid, x - 1, y, count);
        // Down
        if (x + 1 < grid.length) count = calculateIslandSizeAndCompareToCurrentMax(grid, x + 1, y, count);
        // Left
        if (y - 1 >= 0) count = calculateIslandSizeAndCompareToCurrentMax(grid, x, y - 1, count);
        // Right
        if (y + 1 < grid[0].length) count = calculateIslandSizeAndCompareToCurrentMax(grid, x, y + 1, count);

        return count;
    }
}
