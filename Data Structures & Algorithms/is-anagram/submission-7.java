class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            arr1[curr]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int curr = t.charAt(i) - 'a';
            arr2[curr]++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
