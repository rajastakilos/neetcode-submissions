class Solution {
    private int numIslands = 0;
    public int numIslands(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    mapIsland(grid, row, col);
                }
            }
        }

        return numIslands;
    }

    private void mapIsland(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') return;
        
        grid[row][col] = '0';

        if (row - 1 >= 0) mapIsland(grid, row - 1, col);
        if (row + 1 < grid.length) mapIsland(grid, row + 1, col);
        if (col - 1 >= 0) mapIsland(grid, row, col - 1);
        if (col + 1 < grid[0].length) mapIsland(grid, row, col + 1);
    }
}
