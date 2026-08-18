class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (Integer element : set) {
            int currentLongest = 1;
            int currentStreak = element + 1;
            if (!set.contains(element - 1)) { // Prevent O(n^2) behavior
                while (set.contains(currentStreak)) {
                    currentLongest++;
                    currentStreak++;
                }
                longestSequence = Math.max(currentLongest, longestSequence);                
            }

        }

        return longestSequence;
    }
}
// Time: O(n): 
// Space: O(n). Made a hash set that contains all unique values from the input array.