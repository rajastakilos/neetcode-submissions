class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int dp[] = new int[n + 1]; // # ways to reach step i is dp[i].
        dp[1] = 1; // ways to reach step 1.
        dp[2] = 2; // ways to reach step 2.

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            // Number of ways to reach the current step equals the number of ways to reach the previous step, 
            // plus the number of ways to reach two steps before the current step.
        }

        return dp[n];
    }
}
