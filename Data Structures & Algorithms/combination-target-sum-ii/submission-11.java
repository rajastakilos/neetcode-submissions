class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, subset, result);
        return result;
    }

    private void backtrack(int start, int target, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtrack(i + 1, target - nums[i], nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
