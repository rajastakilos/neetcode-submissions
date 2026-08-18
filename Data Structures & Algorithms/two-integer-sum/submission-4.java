class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (m.get(diff) == null) {
                m.put(nums[i], i);
            } else {
                return new int[]{m.get(diff), i};
            }
        }

        return new int[]{};
    }
}
