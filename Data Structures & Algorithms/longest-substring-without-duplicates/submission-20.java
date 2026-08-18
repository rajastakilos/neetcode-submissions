class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // Fix Window.
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            // Start tracking elements again now that duplicate is removed from seen
            seen.add(s.charAt(right));
            
            // Compare current window to previous max
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}

// right - left + 1 is always the window.

// right=0: a      -> [a]         max=1
// right=1: b      -> [a b]       max=2
// right=2: c      -> [a b c]     max=3
// right=3: b dup  -> remove a
//                   [b c]
//                   still dup -> remove b
//                   [c]
//                   add b -> [c b]
// right=4: d      -> [c b d]     max=3
// right=5: e      -> [c b d e]   max=4