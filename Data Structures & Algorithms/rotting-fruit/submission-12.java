class Solution {
    private int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int timeToRotAllFruit = 0;
        int freshCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) freshCount++;
                if (grid[row][col] == 2) q.offer(new int[]{row, col});
            }
        }

        while (freshCount > 0 && !q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] freshFruitPoint = q.poll();
                for (int[] dir : DIRS) {
                    int x = freshFruitPoint[0] + dir[0];
                    int y = freshFruitPoint[1] + dir[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
                    if (grid[x][y] != 1) continue;
 
                    grid[x][y] = 2;
                    freshCount--;
                    q.offer(new int[]{x, y});
                }
            }
            timeToRotAllFruit++;
        }

        return freshCount == 0 ? timeToRotAllFruit : -1;
    }
}
