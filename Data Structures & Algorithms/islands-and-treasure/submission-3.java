class Solution {
    Queue<int[]> q = new ArrayDeque<>();
    int[][] DIRS = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
    int UNVISITED_EMPTY_ROOM = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Add all treasures. BFS simultaneously. 
                if (grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        if (q.size() == 0) return;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : DIRS) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
                    grid[x][y] != UNVISITED_EMPTY_ROOM) {
                        continue;
                }
                
                q.add(new int[]{x, y}); // New node (coordinate)
                grid[x][y] = grid[curr[0]][curr[1]] + 1; // Assign distance.
            }
        }
    }
}

// DFS from every empty cell: “How far is this room from the nearest treasure?” done repeatedly
// BFS from every empty cell: same question, still repeated
// Multi-source BFS from all treasures: start from every treasure at once and spread outward once