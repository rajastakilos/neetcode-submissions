class Solution {
    private int numSubStrings = 0;
    public int countSubstrings(String s) {
        for (int center = 0; center < s.length(); center++) {
            growFromMiddle(center, center, s); // odd palindromes.
            growFromMiddle(center, center + 1, s); // even palindromes.
        }

        return numSubStrings;
    }

    private void growFromMiddle(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            numSubStrings++;
            left--;
            right++;
        }
    }
}
