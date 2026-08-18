class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int oneBack = 2; // newer state. One step behind current.
        int twoBack = 1; // older state. Two steps behind current.

        for (int i = 3; i <= n; i++) {
            int current = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
// Let me define the recurrence first.
// “At each step, 
// I can either come from 1 step below or 2 steps below.”

// Since each state depends only on the previous two states, 
// we only need to store the last two computed values and roll them forward each iteration.
