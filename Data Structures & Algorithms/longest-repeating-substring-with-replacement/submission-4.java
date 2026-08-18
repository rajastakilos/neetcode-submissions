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

            windowSize = right - left + 1;
            maxFreq = Math.max(letterCount[currentLetter], maxFreq);

            if (windowSize - maxFreq > k) { // Key Invariant: If WS - maxFreq > k we must take action. 
                while (windowSize - maxFreq > k) {
                    letterCount[s.charAt(left) - 'A']--;
                    windowSize--;
                    left++;
                }
            }
            
            longestString = Math.max(longestString, right - left + 1);
            right++;
        }

        return longestString;
    }
}

// Time: O(n). We touch each character in the string at most once.
// Space: O(m). We create an array of 26 elements representing each letter of the alphabet. 
    // I specify m instead of n because m has a limit of 26 while the string n can be enormous. 
