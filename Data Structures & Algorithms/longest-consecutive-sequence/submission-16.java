class Solution {
    public int longestConsecutive(int[] nums) {
        int bestStreak = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        for (int i = 0; i < nums.length; i++) {
            int currentStreak = 1;
            int currentNum = nums[i];

            if (seen.contains(currentNum - 1)) continue; // Seen this streak before. 
            while (seen.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            bestStreak = Math.max(bestStreak, currentStreak);
        }

        return bestStreak;
    }
}
