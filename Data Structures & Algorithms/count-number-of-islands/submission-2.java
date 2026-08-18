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

    private void mapIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }
        // Up
        if (i - 1 >= 0) mapIsland(grid, i - 1, j);
        // Down
        if (i + 1 < grid.length) mapIsland(grid, i + 1, j);
        // Left
        if (j - 1 >= 0) mapIsland(grid, i, j - 1);
        // Right
        if (j + 1 < grid[0].length) mapIsland(grid, i, j + 1);
    }
}

// Graph: Each cell is a node. Each cell is connected logically by adjacent 1's (edges)
// DFS: It starts with a cell (node) and looks for all reachable nodes before moving to a new starting point.
// Time: O(m * n). Must check each cell. Dimensions are m * n. 
// Space: O(m * n) Recursion stack is equivalent to m * n cells. 
