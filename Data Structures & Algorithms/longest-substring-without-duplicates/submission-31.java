class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0;
        Set<Character> seen = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Fix
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }
            // Expand
            if (seen.add(s.charAt(right))) {
                longestSubstring = Math.max(longestSubstring, right - left + 1);
            }

        }

        return longestSubstring;

    }
}
