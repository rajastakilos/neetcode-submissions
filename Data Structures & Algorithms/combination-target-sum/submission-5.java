class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, target, nums, subset, result);
        return result;
    }

    private void backtrack(int start, int target, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(i, target - nums[i], nums, subset, result); // Key
            subset.remove(subset.size() - 1);
        }
    }
}
