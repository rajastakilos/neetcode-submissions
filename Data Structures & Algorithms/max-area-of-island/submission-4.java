class Solution {
    private int maxIslandSize = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentIslandSize = mapIsland(grid, i, j);
                maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
            }
        }

        return maxIslandSize;
    }

    private int mapIsland(int[][] grid, int x, int y) {
        // Exceeds graph or is a 0
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        // Is a 1
        grid[x][y] = 0;

        return 1
            + mapIsland(grid, x - 1, y)
            + mapIsland(grid, x + 1, y)
            + mapIsland(grid, x, y - 1)
            + mapIsland(grid, x, y + 1);
    }
}

