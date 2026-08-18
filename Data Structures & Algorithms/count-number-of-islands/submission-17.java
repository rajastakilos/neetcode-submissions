class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    mapIsland(row, col, grid);
                }
            }
        }

        return islandCount;
    }

    private void mapIsland(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || 
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        mapIsland(row + 1, col, grid);
        mapIsland(row - 1, col, grid);
        mapIsland(row, col + 1, grid);
        mapIsland(row, col - 1, grid);
    }
}
