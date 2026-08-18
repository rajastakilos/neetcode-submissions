class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(1, n, k, subset, result);
        return result;
    }

    private void backtrack(int start, int end, int limit, List<Integer> subset, List<List<Integer>> result) {
        if (subset.size() > limit) return;
        if (subset.size() == limit) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i <= end; i++) {
            subset.add(i);
            backtrack(i + 1, end, limit, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}