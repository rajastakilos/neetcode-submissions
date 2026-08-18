class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates); // So we can use if.
        backtrack(0, target, candidates, subset, result);
        return result;
    }

    private void backtrack(int start, int target, int[] candidates,
        List<Integer> subset, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            subset.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, subset, result);
            subset.remove(subset.size() - 1);
        }

    }
}
