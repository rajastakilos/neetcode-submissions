class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int UNVISITED_EMPTY_ROOM = Integer.MAX_VALUE;
        int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };
        Deque<int[]> q = new ArrayDeque<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) q.offer(new int[]{row, col});
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int[] dir : DIRECTIONS) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
                // if (grid[x][y] == -1) continue;
                // if (grid[x][y] == 0) continue;
                if (grid[x][y] != UNVISITED_EMPTY_ROOM) continue;

                grid[x][y] = grid[point[0]][point[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }
}
