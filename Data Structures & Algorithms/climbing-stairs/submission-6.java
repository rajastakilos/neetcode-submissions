class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1]; // ground
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// “This looks like a dynamic programming problem because 
// we need the number of ways to reach step n, and that result 
// depends on smaller subproblems. Specifically, 
// any path to step n must come from step n-1 or n-2, 
// so the total ways is the sum of those two states. 
// A naive recursive solution would recompute the same states many times, 
// so DP lets us store prior results and solve efficiently.”