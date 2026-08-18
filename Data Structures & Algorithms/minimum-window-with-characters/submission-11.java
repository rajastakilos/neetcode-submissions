class Solution {
    public String minWindow(String s, String t) {
        int[] tCounts = new int[128];
        for (int i = 0; i < t.length(); i++) tCounts[t.charAt(i)]++;

        int required = 0;
        for (int i = 0; i < 128; i++) if (tCounts[i] > 0) required++;

        int[] window = new int[128];
        int formed = 0;

        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            // window[s.charAt(right)]++;
            if (tCounts[s.charAt(right)] > 0 && ++window[s.charAt(right)] == tCounts[s.charAt(right)]) {
                formed++;
            }

            // Fix + Record while valid
            while (formed == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                window[s.charAt(left)]--;

                if (tCounts[s.charAt(left)] > 0 && window[s.charAt(left)] < tCounts[s.charAt(left)]) {
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