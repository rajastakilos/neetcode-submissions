class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            arr1[ch]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int ch = t.charAt(i) - 'a';
            arr1[ch]--;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != 0) return false;
        }

        return true;
    }
}
