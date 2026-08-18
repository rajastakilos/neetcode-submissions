class Solution {
    public boolean isPalindrome(String s) {
        // 0. 2 pointers
        int left = 0;
        int right = s.length() - 1;

        // 1. while loop
        while (left < right) {
            // 2. Move both pointers past non-alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            // 3. Compare characters.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            // 4. update pointers
            left++;
            right--;
        }

        return true;
    }
    // Time: O(n)
    // Space: O(1)
    // Why not Time: O(n^2): “Each character is processed at most once because the pointers only move inward and never revisit positions.”
}
