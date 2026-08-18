class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int minWindow = Integer.MAX_VALUE;
        String minString = "";

        int[] window = new int[128]; // ASCII size to handle lower and upper case
        int[] counts = new int[128]; // char maps directly to ASCII characters. 
        for (int i = 0; i < t.length(); i++) counts[t.charAt(i)]++;

        int required = 0;
        for (int i = 0; i < 128; i++) if (counts[i] > 0) required++;

        int requiredCharacterCount = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            if (counts[s.charAt(right)] > 0) { // The char matches a char in t.
                if (counts[s.charAt(right)] == ++window[s.charAt(right)]) requiredCharacterCount++;
            }

            if (requiredCharacterCount == required) {
                while (requiredCharacterCount == required) {
                    // Record: Our substring may still contain all of t.
                    if (right - left + 1 < minWindow) {
                        minWindow = right - left + 1;
                        minString = s.substring(left, right + 1);    
                    } 
                    // Fix
                    if (counts[s.charAt(left)] > 0) { // The char matches a char in t.
                        if (window[s.charAt(left)] == counts[s.charAt(left)]) { 
                            requiredCharacterCount--;
                        }
                        window[s.charAt(left)]--;
                    }

                    left++;
                }
            }
        }

        return minString;
    }
}
