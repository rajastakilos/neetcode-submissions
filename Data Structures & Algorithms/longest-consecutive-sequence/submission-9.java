class Solution {
    public int longestConsecutive(int[] nums) {
        // 0. Our result
        int longestStreak = 0;
        // 1. Add all numbers to set.
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) numbers.add(num);

        // 2. Loop through numbers
        for (int num : numbers) {
            // 3. Only count from 4 if 3 isn't present. Else we're in the middle of a streak already counted once.
            if (numbers.contains(num - 1)) continue;

            int currentNum = num;
            int currentStreak = 1;
            // 4. Check consecutive numbers
            while (numbers.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            // 5. update streak
            longestStreak = Math.max(currentStreak, longestStreak);
        }

        return longestStreak;

    }

}
