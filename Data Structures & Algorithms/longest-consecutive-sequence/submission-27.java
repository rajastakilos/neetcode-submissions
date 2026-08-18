class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSeq = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i] - 1)) continue;

            int current = nums[i];
            int currentLongest = 1;

            while (seen.contains(current + 1)) {
                current++;
                currentLongest++;
            }

            longestSeq = Math.max(longestSeq, currentLongest);
        }

        return longestSeq;
    }
}
