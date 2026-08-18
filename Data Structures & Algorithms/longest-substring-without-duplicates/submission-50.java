class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        int[] window = new int[256];
        int bestLength = Integer.MIN_VALUE;
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            window[s.charAt(right)]++;

            // Fix
            while (window[s.charAt(right)] > 1) {
                window[s.charAt(left)]--;
                left++;
            }

            // Record
            bestLength = Math.max(right - left + 1, bestLength);
        }

        return bestLength;
    }
}
