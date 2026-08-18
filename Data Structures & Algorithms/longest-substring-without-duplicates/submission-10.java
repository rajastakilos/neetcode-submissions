class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seenSet = new HashSet<>();
        int longestLength = 0;
        int currentLongest = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (seenSet.add(s.charAt(right))) {
                currentLongest++;
                longestLength = Math.max(currentLongest, longestLength);
                right++;
            } else {
                while (seenSet.contains(s.charAt(right))) {
                    seenSet.remove(s.charAt(left));
                    currentLongest--;
                    left++;
                }
            }
        }

        return longestLength;
    }
}
