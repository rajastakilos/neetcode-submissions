class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        for (int num : nums) {
            if (seen.contains(num - 1)) continue; // Make sure we aren't in the middle of a streak;
        
            int currentNum = num;
            int currentStreak = 1;

            while (seen.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
        
    }
}
