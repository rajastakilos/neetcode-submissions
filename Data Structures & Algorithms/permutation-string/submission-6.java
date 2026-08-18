class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] targetCount = new int[26];
        for (int i = 0; i < s1.length(); i++) targetCount[s1.charAt(i) - 'a']++;

        int[] windowCount = new int[26];

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            // Expand
            windowCount[s2.charAt(right) - 'a']++;

            // Fix: Enforce Invariant: Window only includes letters in s1.
            while (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;    
                left++;
            }

            // Record / Return
            if (right - left + 1 == s1.length() && 
            Arrays.equals(targetCount, windowCount)) return true;

        }

        return false;
    }
}
