class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxCountSingleChar = 0;
        int[] counts = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            counts[s.charAt(right) - 'A']++;
            maxCountSingleChar = Math.max(maxCountSingleChar, counts[s.charAt(right) - 'A']);

            // Fix
            while ((right - left + 1) - maxCountSingleChar > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            // Record
            longest = Math.max(longest, right - left + 1);
        }

        return longest;

    }
}
