class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seenSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int longestSubStringLength = 0;

        while (right < s.length()) {
            if (seenSet.add(s.charAt(right))) {
                longestSubStringLength = Math.max(longestSubStringLength, right - left + 1);
                right++;
            } else {
                while (seenSet.contains(s.charAt(right))) {
                    seenSet.remove(s.charAt(left));
                    left++;
                }
            }
        }

        return longestSubStringLength;
    }
}
