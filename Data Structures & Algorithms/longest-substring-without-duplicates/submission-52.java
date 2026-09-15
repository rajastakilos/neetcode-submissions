class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int longestSubstring = Integer.MIN_VALUE;
        int[] window = new int[256];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            window[s.charAt(right)]++;

            // Fix
            while (window[s.charAt(right)] > 1) { // Key 1. 
                window[s.charAt(left)]--;
                left++;
            }

            // Record
            longestSubstring = Math.max(right - left + 1, longestSubstring); // 
        }

        return longestSubstring;
    }
}
