class Solution {
    private int bestLen = 0; // TODORAJAS: Pass to fx?
    private int start = 0;

    public String longestPalindrome(String s) {

        for (int center = 0; center < s.length(); center++) {
            growFromMiddle(center, center, s);
            growFromMiddle(center, center + 1, s);
        }

        return s.substring(start, start + bestLen);
    }

    private void growFromMiddle(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int currStart = left + 1;
        int currEnd = right - 1;
        int currLength = currEnd - currStart + 1;
        if (currLength > bestLen) {
            start = currStart;
            bestLen = currLength;
        }
    }
}
