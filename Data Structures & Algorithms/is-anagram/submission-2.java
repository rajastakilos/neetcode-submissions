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
