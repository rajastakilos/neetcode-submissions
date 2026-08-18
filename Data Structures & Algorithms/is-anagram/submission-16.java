class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];

        for (Character c : s.toCharArray()) counts[c - 'a']++;
        for (Character c : t.toCharArray()) counts[c - 'a']--;

        for (int count : counts) if (count != 0) return false;

        return true;
    }
}
