class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = temp;
        }

        return Math.min(prev2, prev1);
    }
}
