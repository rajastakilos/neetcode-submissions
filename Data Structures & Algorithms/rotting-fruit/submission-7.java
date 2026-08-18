class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int fresh = 0;
        int time = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) fresh++;
                if (grid[row][col] == 2) q.offer(new int[]{row, col});
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int[] dir : DIR) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
                    if (grid[x][y] != 1) continue;
                    // if (grid[x][y] == 2) continue;
                    
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1; 
    }
}
