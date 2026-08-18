class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text2.length();
        int[] dp = new int[n + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            int prev = 0; // this represents dp[i+1][j+1]

            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j]; // save dp[i+1][j] before overwriting

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }

                prev = temp; // move diagonal forward
            }
        }

        return dp[0];
    }
}