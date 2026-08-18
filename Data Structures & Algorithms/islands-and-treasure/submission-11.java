class Solution {
    Queue<int[]> q = new ArrayDeque<>();
    int[][] DIRS = {
        { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0 , 1}
    };
    int UNVISITED_EMPTY_ROOM = Integer.MAX_VALUE;
    
    public void islandsAndTreasure(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) q.offer(new int[]{row, col}); // Find treasure chests. Expand from here. 
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : DIRS) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue; // boundary
                if (grid[x][y] == -1) continue;
                if (grid[x][y] == 0) continue;
                if (grid[x][y] != UNVISITED_EMPTY_ROOM) continue;

                q.add(new int[]{x, y}); // Expand from here. 
                grid[x][y] = grid[curr[0]][curr[1]] + 1; 
                // The shortest distance to a treasure for this neighbor is one more than the current cell.

            }
        }
    }
}
