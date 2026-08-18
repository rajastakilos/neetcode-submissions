class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxCountSingleChar = 0;
        int longestString = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand: Count Single Char
            // counts[s.charAt(right) - 'A']++;
            maxCountSingleChar = Math.max(maxCountSingleChar, ++counts[s.charAt(right) - 'A']);
            
            // Fix: Window + SingleChar count exceeds k.
            while ((right - left + 1) - maxCountSingleChar > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            longestString = Math.max(longestString, right - left + 1);
        }

        return longestString;
    }
}
