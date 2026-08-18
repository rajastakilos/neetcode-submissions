class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) numbers.add(num);

        int longestStreak = 0;

        for (int num : numbers) {
            // Only count from 4 if 3 isn't present. Else we're in the middle of a streak already counted once.
            if (numbers.contains(num - 1)) continue;

            int currentNum = num;
            int currentStreak = 1;

            while (numbers.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(currentStreak, longestStreak);
        }

        return longestStreak;

    }

}
