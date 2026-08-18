class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Ensure validity of window before expanding. 
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

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