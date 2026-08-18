class Solution {
    private int areaOfLargestIsland = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int currentIslandArea = mapIsland(grid, row, col);
                    areaOfLargestIsland = Math.max(areaOfLargestIsland, currentIslandArea);
                }
            }
        }

        return areaOfLargestIsland;
    }

    private int mapIsland(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        // if (row < 0 || 
        //     row >= grid.length || 
        //     col < 0 || 
        //     col >= grid[0].length || 
        //     grid[row][col] == 0) return 0;

        // return 1
        //     + mapIsland(grid, row - 1, col)
        //     + mapIsland(grid, row + 1, col)
        //     + mapIsland(grid, row, col - 1)
        //     + mapIsland(grid, row, col + 1);

        int area = 1;

        if (row - 1 >= 0) area += mapIsland(grid, row - 1, col);
        if (row + 1 < grid.length) area += mapIsland(grid, row + 1, col);
        if (col - 1 >= 0) area += mapIsland(grid, row, col - 1);
        if (col + 1 < grid[0].length) area+= mapIsland(grid, row, col + 1);

        return area;
    }
}
