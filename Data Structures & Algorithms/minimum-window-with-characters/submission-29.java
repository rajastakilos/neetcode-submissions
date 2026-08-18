class Solution {
    public String minWindow(String s, String t) {
        int required = 0;
        int[] tCounts = new int[128];
        for (int i = 0; i < t.length(); i++) tCounts[t.charAt(i)]++;
        for (int i = 0; i < 128; i++) if (tCounts[i] > 0) required++;
        
        int[] sCounts = new int[128];
        int formed = 0;
        
        int start = 0;
        int end = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand
            if (++sCounts[s.charAt(right)] == tCounts[s.charAt(right)]) formed++;

            // Fix and Record
            while (formed == required) {
                if (right - left + 1 < end) {
                    start = left;
                    end = right - left + 1;
                }
                if (--sCounts[s.charAt(left)] < tCounts[s.charAt(left)]) formed--;
                left++;
            }

        }

        return end == Integer.MAX_VALUE ? 
            "" :
            s.substring(start, start + end);
    }
}

