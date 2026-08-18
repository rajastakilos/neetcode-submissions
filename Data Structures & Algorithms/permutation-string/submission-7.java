class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1counts = new int[26];
        for (int i = 0; i < s1.length(); i++) s1counts[s1.charAt(i) - 'a']++;
        int[] s2counts = new int[26];

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            // Expand
            s2counts[s2.charAt(right) - 'a']++;
            
            // Fix
            if (right - left + 1 > s1.length()) {
                s2counts[s2.charAt(left) - 'a']--;
                left++;
            }

            // Record / Check
            if (Arrays.equals(s1counts, s2counts)) {
                return true;
            }
        }

        return false;
    }
}
