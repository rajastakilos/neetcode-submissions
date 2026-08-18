class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int longestString = 0;
        int windowSize = 0;
        int maxFreq = 0;
        int[] letterCount = new int[26];

        while (right < s.length()) {
            int currentLetter = s.charAt(right) - 'A';
            letterCount[currentLetter]++;

            maxFreq = Math.max(letterCount[currentLetter], maxFreq);
            windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                while (windowSize - maxFreq > k) {
                    windowSize--;
                    letterCount[s.charAt(left) - 'A']--;
                    left++;
                }
            } else {
                longestString = Math.max(longestString, right - left + 1);
            }
            right++;
        }

        return longestString;
    }
}
