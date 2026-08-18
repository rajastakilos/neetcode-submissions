class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] letterCounts = new int[26];
        int[] matches = new int[26];
        for (int i = 0; i < s1.length(); i++) matches[s1.charAt(i) - 'a']++;
        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            int currentLetter = s2.charAt(right) - 'a';
            letterCounts[currentLetter]++;
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(letterCounts, matches)) 
                // {
                    return true;
                // else {
                    letterCounts[s2.charAt(left) - 'a']--;
                    left++;
                // }
            }
            right++;
        }

        return false;
    }
}
// Time: O(n). We touch every element in the string once. Arrays.equals runs in O(k) time where k is length of the arrays.
// Space: We initialize two arrays of size 26. However, O(1) since these arrays don't scale with the input. 
