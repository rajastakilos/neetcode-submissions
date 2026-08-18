class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if (r == grid.length - 1 && c == grid.length - 1) return t;

            for (int[] dir : directions) {
                int neiR = r + dir[0];
                int neiC = c + dir[1];
                if (neiR >= 0 && neiC >= 0 &&
                    neiR < grid.length && 
                    neiC < grid.length &&
                    !visit[neiR][neiC]) {
                    visit[neiR][neiC] = true;
                    minHeap.offer(new int[]{
                        Math.max(t, grid[neiR][neiC]),
                        neiR, neiC
                    });
                }
            }
        }
        return grid.length * grid.length;
    }
}


// In classic Dijkstra, we usually track 
    // the best known distance to each node.
// Here we track the best known time to each cell.