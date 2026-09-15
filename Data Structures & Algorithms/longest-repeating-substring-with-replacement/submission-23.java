class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxCount = 0;
        int[] window = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            window[s.charAt(right) - 'A']++;
            for (int count: window) {
                maxCount = Math.max(maxCount, count);
            }
            
            // Fix
            while ((right - left + 1) - maxCount > k) {
                window[s.charAt(left) - 'A']--;
                left++;
            }

            // Record
            longest = Math.max(right - left + 1, longest);
        }

        return longest;

    }
}
