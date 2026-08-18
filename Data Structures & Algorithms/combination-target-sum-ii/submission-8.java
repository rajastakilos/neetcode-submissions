class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates); // Key
        backtrack(0, target, candidates, path, result);
        return result;
    }

    private void backtrack(int start, int target, int[] candidates, List<Integer> path, List<List<Integer>> result) {
        if (target < 0) return; // Key: Don't drop below 0. 
        if (target == 0) { 
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) { // Key : start
            // Prevents duplicate combinations. "Unique combinations".
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            path.add(candidates[i]);
            // Key: Each element chosen at most once. "at most once"
            backtrack(i + 1, target - candidates[i], candidates, path, result);
            path.remove(path.size() - 1);
        }
    }
}
