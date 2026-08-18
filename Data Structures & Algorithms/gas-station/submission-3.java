class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0; // global
        int tank = 0; // local
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}

// If the cumulative tank becomes negative at index i, 
// we cannot reach i + 1 from our current start.

// Total tells me if the game is winnable
// Tank tells me if my current start is still viable

// No matter how messy the local segments are, 
// if the total sum ≥ 0, a valid start must exist.
// [-3, +5, -2, +4, -1]
// total = +3 → solution exists ✅