class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(nums[0], 0);
        // Does difference between current number and target exist in the seen map?

        for (int i = 1; i < nums.length; i++) {
            int diff = target - nums[i];
            if (seen.containsKey(diff)) {
                return new int[]{seen.get(diff), i};
            } else {
                seen.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
