class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, target, 0, subset, result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> subset, List<List<Integer>> result) {
        if (target == 0) { 
            result.add(new ArrayList<>(subset));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, target - nums[i], i, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
