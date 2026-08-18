class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] DIR = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // 1. 
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : DIR) {
                    int r = x + dir[0];
                    int c = y + dir[1];

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue; // boundaries
                    if (grid[r][c] == 0) continue;
                    if (grid[r][c] == 2) continue;

                    grid[r][c] = 2; // mark it visited;
                    q.offer(new int[]{r, c});
                    fresh--; // Rotted a fresh banana.
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
