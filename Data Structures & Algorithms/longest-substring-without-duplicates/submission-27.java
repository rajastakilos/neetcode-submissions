class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestString = 0;
        Set<Character> chars = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Fix
            while (chars.contains(s.charAt(right))) {
                chars.remove(s.charAt(left));
                left++;
            }

            // Expand
            chars.add(s.charAt(right));

            // Record
            longestString = Math.max(longestString, right - left + 1);
        }

        return longestString;    
    }
}
