class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestString = 0;
        int[] window = new int[128];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            // window[s.charAt(right)]++;

            // Fix
            if (++window[s.charAt(right)] > 1) {
                while (window[s.charAt(right)] > 1) {
                    window[s.charAt(left)]--;
                    left++;
                }
            }

            // Record
            longestString = Math.max(longestString, right - left + 1);
        }

        return longestString;
    }
}
