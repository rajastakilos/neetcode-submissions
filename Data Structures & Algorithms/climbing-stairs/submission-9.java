class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1]; // + 1 because 0 is the ground.
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
// Ex. n = 3
// Step 1: dp[1] = 1  (ways: [1])
// Step 2: dp[2] = 2  (ways: [1,1], [2])
// Step 3: dp[3] = 3  (ways: [1,1,1], [1,2], [2,1])

// Recursive top-down naturally creates a call tree where multiple parents may request the same child state.
// Bottom-up uses a linear pass over states. You explicitly visit each state one time in dependency order.