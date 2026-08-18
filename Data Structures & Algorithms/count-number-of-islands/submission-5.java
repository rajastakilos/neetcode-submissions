class Solution {
    private int islandCount = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    countNumIslands(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void countNumIslands(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        } else {
            return;
        }
        // Up
        if (x -1 >= 0) countNumIslands(grid, x - 1, y);
        // Down
        if (x + 1 < grid.length) countNumIslands(grid, x + 1, y);
        // Left
        if (y - 1 >= 0) countNumIslands(grid, x, y - 1);
        // Right
        if (y + 1 < grid[0].length) countNumIslands(grid, x, y + 1);
    }
}
