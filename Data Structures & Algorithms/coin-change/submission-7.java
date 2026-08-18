class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // index 0 through amount.
        Arrays.fill(dp, amount + 1); // We are doing Math.min. We want to to compare with an impossible value. amount + 1 is always larger. 
        dp[0] = 0; // It takes 0 coins to make amount 0;
        // dp[i] = fewest coins needed to make amount i
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    int remainingAmount = currentAmount - coin;
                    int candidate = dp[remainingAmount] + 1;

                    dp[currentAmount] = Math.min(dp[currentAmount], candidate);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}

// // min problem
// Arrays.fill(dp, INF);
// dp[0] = 0;

// // max problem
// Arrays.fill(dp, -INF);
// dp[0] = 0;

// // count ways problem
// dp[0] = 1;
