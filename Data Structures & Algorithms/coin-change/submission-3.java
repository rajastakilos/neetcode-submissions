class Solution {
    private int fewestCoins = 0;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        List<Integer> subset = new ArrayList<>();
        backtrack(0, amount, coins, subset);
        return fewestCoins == 0 ? -1 : fewestCoins;
    }

    private void backtrack(int start, int amount,
        int[] coins, List<Integer> subset) {
        if (amount < 0) return;
        if (amount == 0) {
            if (fewestCoins == 0) {
                fewestCoins = subset.size(); 
            } else {
                fewestCoins = Math.min(fewestCoins, subset.size());
            } 
            return;
        }

        for (int i = start; i < coins.length; i++) {
            subset.add(coins[i]);
            // Note: No i + 1 since we want to be able to use the same coin over again.
            backtrack(i, amount - coins[i], coins, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
