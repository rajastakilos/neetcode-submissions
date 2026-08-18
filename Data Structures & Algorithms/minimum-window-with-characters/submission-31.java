class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (t.length() > s.length()) return result;
        int currentCount = 0;
        int requiredCount = 0;

        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) tCount[t.charAt(i)]++;
        for (int i = 0; i < 128; i++) if (tCount[i] > 0) requiredCount++;
        int[] sCount = new int[128];

        int start = 0;
        int bestLength = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (++sCount[s.charAt(right)] == tCount[s.charAt(right)]) {
                currentCount++;
            }

            while (currentCount == requiredCount) {
                if (right - left + 1 < bestLength) {
                    start = left;
                    bestLength = right - left + 1;
                }

                --sCount[s.charAt(left)];
                if (sCount[s.charAt(left)] < tCount[s.charAt(left)]) {
                    currentCount--;
                }
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ? result : s.substring(start, start + bestLength);
    }
}
