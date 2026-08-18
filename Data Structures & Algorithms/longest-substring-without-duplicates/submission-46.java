class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int longest = 0;
        int[] counts = new int[256];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            counts[s.charAt(right)]++;

            // Fix
            while (counts[s.charAt(right)] > 1) {
                counts[s.charAt(left)]--;
                left++;
            }

            // Record
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
