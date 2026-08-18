class Solution {
    private final int[][] DIRS = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(heights, pac, row, 0);        // Pacific Left.
            dfs(heights, atl, row, cols - 1); // Atlantic Right.
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, pac, 0, col); // Pacific Top
            dfs(heights, atl, rows - 1, col); // Atlantic Bottom
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pac[row][col] && atl[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] seen, int row, int col) {
        if (seen[row][col]) return;
        seen[row][col] = true;

        for (int[] dir : DIRS) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) continue;
            if (heights[nr][nc] < heights[row][col]) continue; // reverse flow: only uphill/flat

            dfs(heights, seen, nr, nc);
        }
    }
}
