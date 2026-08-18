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
        // Exceeds boundaries of graph or is zero.
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        } else {
            grid[x][y] = '0';

            countNumIslands(grid, x - 1, y);
            countNumIslands(grid, x + 1, y);
            countNumIslands(grid, x, y - 1);
            countNumIslands(grid, x, y + 1);
        }
    }
}
