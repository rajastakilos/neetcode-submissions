class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastSeen.put(s.charAt(i), i);
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            right = Math.max(right, lastSeen.get(c));

            if (i == right) {
                int size = right - left + 1;
                result.add(size);
                left = i + 1;
            }
        }

        return result;
    }
}
// “Expand the current partition until it safely contains 
// all characters we've seen so far.”