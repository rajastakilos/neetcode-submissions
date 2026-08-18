class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int dp[] = new int[n + 1];
        dp[0] = 1; // one step to get to step 1.
        dp[1] = 2; // two ways to get to step 2: 1 step twice or 2 steps.

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
