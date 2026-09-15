class Solution {
    public int longestConsecutive(int[] nums) {
        // Part 1
        int longestConsecutive = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        for (int i = 0; i < nums.length; i++) {
            // Part 2
            if (seen.contains(nums[i] - 1)) continue; // Skip intermediate

            // Part 3
            int current = nums[i];
            int currentLongest = 1;
            while (seen.contains(current + 1)) {
                current++;
                currentLongest++;
            }
            
            // Part 4.
            longestConsecutive = Math.max(
                    longestConsecutive, 
                    currentLongest);
        }

        return longestConsecutive;
    }
}
