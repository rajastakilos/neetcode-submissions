class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, mapIsland(row, col, grid));
                }
            }
        }
        
        return maxArea;
    }

    private int mapIsland(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || 
            row >= grid.length || 
            col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + 
            mapIsland(row + 1, col, grid) +
            mapIsland(row - 1, col, grid) + 
            mapIsland(row, col + 1, grid) +
            mapIsland(row, col - 1, grid);
    }
}
