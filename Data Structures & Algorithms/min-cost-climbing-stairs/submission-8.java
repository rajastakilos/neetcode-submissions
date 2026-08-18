class Solution {
    private int[] memo;
    
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));    
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (memo[i] != -1) return memo[i];
        
        memo[i] = cost[i] + Math.min(dfs(cost, i + 1),
                                     dfs(cost, i + 2));

        return memo[i];
    }
}

// We can start at index 0 or index 1. So we know dp[0] and dp[1]. dp[2] is the first to calculate.
