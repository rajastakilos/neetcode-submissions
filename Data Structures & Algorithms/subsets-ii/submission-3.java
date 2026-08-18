class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums); // Diff vs. Subsets 1: Needed for if check
        int lastSize = 0; // Diff vs. Subsets 1

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            int start = 0; // Diff vs. Subsets 1

            if (i > 0 && nums[i] == nums[i - 1]) start = lastSize;

            for (int j = start; j < size; j++) {
                List<Integer> clone = new ArrayList<>(result.get(j));
                clone.add(nums[i]);
                result.add(clone);
            }

            lastSize = size; // Diff vs. Subsets 1. next iterations duplicate starts here.
        }
        
        return result;
    }
}
// Time: O(n * 2^n)
// Space: O(n * 2^n)
