class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    mapIsland(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    public void mapIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }

        // Up and Down
        if (i - 1 >= 0) mapIsland(grid, i - 1, j);
        if (i + 1 < grid.length) mapIsland(grid, i + 1, j);

        // Left and Right
        if (j - 1 >= 0) mapIsland(grid, i, j -1);
        if (j + 1 < grid[0].length) mapIsland(grid, i, j + 1);
    }
}
