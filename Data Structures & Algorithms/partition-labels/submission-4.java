class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) lastSeen.put(s.charAt(i), i);

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, lastSeen.get(s.charAt(i)));

            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
}
// “Expand the current partition until it safely contains 
// all characters we've seen so far.”
// “The window is determined by the farthest last occurrence of any character seen so far, 
// not just the first one.

// Greedy: “Should I close the partition here?”
// “Close the partition as soon as it is safe (i == right)”