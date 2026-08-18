class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                int diff = Math.abs(i - seen.get(nums[i]));
                if (diff <= k) return true;
            }
            seen.put(nums[i], i);
        }

        return false;
    }
}