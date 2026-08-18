class Solution {
    public int characterReplacement(String s, int k) {
        int longestSubstring = 0;
        int maxCountSingleChar = 0;
        int[] counts = new int[256];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {            
            // Expand
            counts[s.charAt(right)]++;
            maxCountSingleChar = Math.max(maxCountSingleChar, counts[s.charAt(right)]);

            // Fix: Enforce the invariant
            while ((right - left + 1) - maxCountSingleChar > k) {
                counts[s.charAt(left)]--;
                left++;
            }

            // Record
            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }

        return longestSubstring;

    }
}
