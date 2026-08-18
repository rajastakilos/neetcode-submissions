class Solution {
    int[][] DIRS = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        // Pacific (top and left)
        for (int i = 0; i < heights.length; i++) dfs(heights, pac, i, 0);
        for (int j = 0; j < heights[0].length; j++) dfs(heights, pac, 0, j);

        // Atlantic (bottom and right)
        for (int i = 0; i < heights.length; i++) dfs(heights, atl, i, heights[0].length - 1);
        for (int j = 0; j < heights[0].length; j++) dfs(heights, atl, heights.length - 1, j);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] h, boolean[][] visited, int x, int y) {
        if (visited[x][y] == true) return;
        visited[x][y] = true;

        for (int[] dir : DIRS) {
            int r = x + dir[0];
            int c = y + dir[1];

            if (r < 0 || r >= h.length || c < 0 || c >= h[0].length) continue; // boundary check

            if (h[r][c] >= h[x][y]) {
                dfs(h, visited, r, c);
            }
        }
    }
}
// Pacific: 0..grid[0].length (0,6), grid.length...0 (6, 0);
// Atlantic: grid[0].length...0 (6,6)
// (0,0) (0,1) (0,2) (0,3) (0,4) (0,5) (0,6)
// (1,0) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6)
// (2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6)
// (3,0) (3,1) (3,2) (3,3) (3,4) (3,5) (3,6)
// (4,0) (4,1) (4,2) (4,3) (4,4) (4,5) (4,6)
// (5,0) (5,1) (5,2) (5,3) (5,4) (5,5) (5,6)
// (6,0) (6,1) (6,2) (6,3) (6,4) (6,5) (6,6)