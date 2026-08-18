class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (Integer element : set) {
            int currentLongest = 1;
            int nextElement = element + 1;
            while (set.contains(nextElement)) {
                currentLongest++;
                nextElement++;
            }
            longestSequence = Math.max(currentLongest, longestSequence);
        }

        return longestSequence;
    }
}
