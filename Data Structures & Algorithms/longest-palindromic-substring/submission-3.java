class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // odd
            int len2 = expandFromCenter(s, i, i + 1); // even

            int currentLength = Math.max(len1, len2);

            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = i - (currentLength - 1) / 2; // Why? 
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) { // Expand from center
            left--; // Expanding from center
            right++; // Expanding from center
        }

        return right - left - 1;
        // "abba"
        // expand to left = -1, right = 4 → stop
        // right - left - 1
        // = 4 - (-1) - 1
        // = 4
    }
}
