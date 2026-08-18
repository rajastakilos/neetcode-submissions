class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] windowCount = new int[26];

        int[] targetCount = new int[26];
        for (int i = 0; i < s1.length(); i++) targetCount[s1.charAt(i) - 'a']++;

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            // Expand window
            windowCount[s2.charAt(right) - 'a']++;

            // Fix Window if violate invariant: window size is never larger than s1.length()
            if (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }
            
            // Check condition.
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(windowCount, targetCount)) return true;
            }
        } 

        return false;
    }
}

// window = right - left + 1;
