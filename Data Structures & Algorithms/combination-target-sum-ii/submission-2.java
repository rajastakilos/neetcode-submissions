class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates); // So we can use if statement in for loop
        dfs(0, target, candidates, result, path);
        return result;
    }

    private void dfs(int start, int remaining, int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (remaining < 0) return;
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return; // Needed?
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Ensure we don't have the same number twice to prevent duplicates.

            path.add(nums[i]); // choose
            dfs(i + 1, remaining - nums[i], nums, result, path); // recurse Note: i + 1 so we don't reuse the same number.
            path.remove(path.size() - 1); // backtrack
        }
    }
}
// Time complexity: O(2n ⋅ n)
// Space complexity: O(n)
    // Recursion depth: O(n)
    // path: O(n)
