class Solution {
    public String minWindow(String s, String t) {
        // if (s.length() < t.length()) return "";

        int[] counts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (counts[i] > 0) required++;
        }

        int[] window = new int[128];
        int formed = 0;

        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            char rightChar = s.charAt(right);
            window[rightChar]++;

            if (counts[rightChar] > 0 && window[rightChar] == counts[rightChar]) {
                formed++;
            }

            // Fix + Record while valid
            while (formed == required) {
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (counts[leftChar] > 0 && window[leftChar] < counts[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE
            ? ""
            : s.substring(bestStart, bestStart + bestLen);
    }
}