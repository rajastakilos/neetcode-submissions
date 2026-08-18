class Solution {
    private int start = 0;
    private int bestLen = 1;
    public String longestPalindrome(String s) {


        for (int center = 0; center < s.length(); center++) {
            growFromMiddle(s, center, center); // odd
            growFromMiddle(s, center, center + 1);
        }

        return s.substring(start, start + bestLen); 
    }

    private void growFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int currStart = left + 1; // After we break we went one too far to the left.
        int currLen = right - left - 1;

        if (currLen > bestLen) {
            start = currStart;
            bestLen = currLen;
        }
    }
}
