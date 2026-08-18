class Solution {
    public int uniquePaths(int m, int n) {
    // ways from the cell below + ways from the cell to the right
        int dp[] = new int[n];
        // We can only move right to get to cells in row 1. Exaclty 1 way: [1, 1, 1, 1, 1];
        Arrays.fill(dp, 1); 
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                // col 1 not 0 because first column is always 1. 
                // dp[col]: above 
                // dp[col - 1]: left
                dp[col] += dp[col - 1];
            }
        }

        return dp[n - 1]; // last cell. 
    }
}
