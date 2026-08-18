class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCounts = new int[26];
        int[] tCounts = new int[26];

        for (int i = 0; i < s.length(); i++) sCounts[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) tCounts[t.charAt(i) - 'a']++;
        for (int i = 0; i < sCounts.length; i++) {
            if (sCounts[i] != tCounts[i]) return false;
        }

        return true;
    }
}
