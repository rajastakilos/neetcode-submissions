class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevNumToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int desiredNumber = target - nums[i];
            if (prevNumToIndexMap.containsKey(desiredNumber)) {
                int desiredIndex = prevNumToIndexMap.get(desiredNumber);
                return new int[]{desiredIndex, i};
            }
            
            prevNumToIndexMap.put(nums[i], i);    
        } 

        throw new IllegalArgumentException("No valid two sum solution"); // Prevent returning null.
    }
}

// Time: O(n). Worst case we must check every number in the input array.
// Space: O(n). Worst case we must add all but the last number to the HashMap.
