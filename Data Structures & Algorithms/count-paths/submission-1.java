class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 1; // bottom-right base case

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 < n) {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}