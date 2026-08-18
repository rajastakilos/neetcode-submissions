class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0; // global
        int tank = 0; // local
        int start = 0; // best candidate

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
