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
            for (int i = 0; i < size; i++) { // 1. Each orange's immediate Up, Down, Left, and Right are its BFS level.
                int[] curr = q.poll();
              
                for (int[] dir : DIR) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    // 2. Is it a fresh orange?
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue; // boundaries
                    if (grid[r][c] == 0) continue;
                    if (grid[r][c] == 2) continue;

                    // 3. Mark it visited and rot it. 
                    grid[r][c] = 2; // mark it visited;
                    q.offer(new int[]{r, c});
                    fresh--; // Rotted a fresh orange.
                }
            }
            time++; // 4. We cleared a level. All orange rotted at the same BFS level are the SAME minute
        }

        return fresh == 0 ? time : -1; // fresh > 0 because we may have isolated oranges. 
    }
}
