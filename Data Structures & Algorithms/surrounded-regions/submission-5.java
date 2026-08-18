class Solution {
    private int[][] DIRS = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
    public void solve(char[][] board) {
        markBorderConnectedOs(board);

        for (int i = 0; i < board.length; i++) { // 3. Set all non-border connected cells to X, then flip all T's back to O's.
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markBorderConnectedOs(char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < board.length; i++) { // 1. Identify Border Cells.
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1 ||
                    j == 0 || j == board[0].length - 1) &&
                    board[i][j] == 'O') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) { // 2. Flip all border connected cells to T. 
            int[] cell = q.poll();
            if (board[cell[0]][cell[1]] == 'O') {
                board[cell[0]][cell[1]] = 'T';
                for (int[] direction : DIRS) {
                    int x = cell[0] + direction[0];
                    int y = cell[1] + direction[1];

                    if (x >= 0 && x < board.length &&
                        y >= 0 && y < board[0].length) {
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}

// Identify all border 'O's.
// From those border 'O's, traverse all connected 'O's and mark them 'T'.
// Any remaining 'O's are surrounded, so flip them to 'X'. Then flip 'T' back to 'O'.
