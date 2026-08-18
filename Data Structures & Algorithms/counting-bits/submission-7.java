class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) { // start at 0 because dp[0] covered by default.
            // dp[0] = 0.
            // i >> 1 means “remove the last binary bit”
            // i = 5  → binary: 101
            // i >> 1 → binary: 10  → decimal: 2
            dp[i] = dp[i >> 1] +
            // i & 1 is the last bit a 1? If 1 return 1 else return 0.
            // 5 = 101 → i & 1 = 1
            // 4 = 100 → i & 1 = 0 
            (i & 1);
        }

        return dp;
    }
}
// TODO: Understand why this is O(1) time and O(n) space.
// DP insight: Using 