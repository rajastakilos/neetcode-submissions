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
                while (seenSet.contains(s.charAt(right))) { // Key: Remove until the duplicate found by right is removed.
                    seenSet.remove(s.charAt(left));
                    currentLongest--;
                    left++;
                }
            }
        }

        return longestLength;
    }
}

// Time: O(n). We must touch each character in the string once.
// Space: O(n). Worst case we must store a length equal to the input string when we have
    // a string of unique characters. 
