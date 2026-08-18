class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
