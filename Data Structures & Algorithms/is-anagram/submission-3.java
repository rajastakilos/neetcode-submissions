class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letterPositionsCountArray = new int[26]; // Assuming lower case letters only.

        for (int i = 0; i < s.length(); i++) {
            letterPositionsCountArray[s.charAt(i) - 'a']++;
            letterPositionsCountArray[t.charAt(i) - 'a']--;
        }

        for (int letterPositionCount : letterPositionsCountArray) {
            if (letterPositionCount != 0) return false;
        }

        return true;
    }
}

// Time: O(n + m) where n is length of s and m is length of t. Simplified to O(n).
// Space: O(n) where n is = 26. 
