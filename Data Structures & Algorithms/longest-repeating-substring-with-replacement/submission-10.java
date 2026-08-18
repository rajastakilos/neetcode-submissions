class Solution { // Type 2: Expand then repair.
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxCountOfSingleChar = 0;
        int longestWindow = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            counts[s.charAt(right) - 'A']++;
            maxCountOfSingleChar = Math.max(maxCountOfSingleChar, counts[s.charAt(right) - 'A']);

            // Fix
            while ((right - left + 1) - maxCountOfSingleChar > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            longestWindow = Math.max(longestWindow, right - left + 1);
        }

        return longestWindow;
    }
}
// window = right - left + 1;