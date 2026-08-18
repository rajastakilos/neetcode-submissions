class Solution {
    private int totalNumOfIslands = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    totalNumOfIslands++;
                    mapIsland(grid, i, j);
                }
            }
        }

        return totalNumOfIslands;
    }

    private void mapIsland(char[][] island, int x, int y) {
        if (island[x][y] == '0') {
            return;
        } else {
            island[x][y] = '0';
        }

        // Up
        if (x - 1 >= 0) mapIsland(island, x - 1, y);
        // Down
        if (x + 1 < island.length) mapIsland(island, x + 1, y);
        // Left
        if (y - 1 >= 0) mapIsland(island, x, y - 1);
        // Right
        if (y + 1 < island[0].length) mapIsland(island, x, y + 1);
    }
}
