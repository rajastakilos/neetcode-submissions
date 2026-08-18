class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        int bestStart = 0;
        int bestLen = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left + len - 1 < s.length(); left++) {
                int right = left + len - 1;

                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else if (len <= 3) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right] && len > bestLen) {
                    bestLen = len;
                    bestStart = left;
                }
            }
        }

        return s.substring(bestStart, bestStart + bestLen);
    }
}
