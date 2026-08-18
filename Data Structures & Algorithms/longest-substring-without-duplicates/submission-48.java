class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int duplicateCount = 0;
        int[] charCount = new int[256];
        int bestLength = Integer.MIN_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            charCount[s.charAt(right)]++;

            // Fix
            while (charCount[s.charAt(right)] > 1) {
                charCount[s.charAt(left)]--;
                left++;
            }

            // Record
            bestLength = Math.max(right - left + 1, bestLength);
        }

        return bestLength;
    }
}
