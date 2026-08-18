class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (map.get(diff) != null) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0]; // Real life. 

        // Current target - current to see if we've seen this in the map.
    }
}
