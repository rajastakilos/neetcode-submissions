class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i] - 1)) continue; // Seen this streak before. 
            
            int currentNum = nums[i];
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
