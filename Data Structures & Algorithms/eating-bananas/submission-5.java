class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int slowest = 1;
        int fastest = getFastestEatingSpeed(piles);

        while (slowest <= fastest) {
            int speed = slowest + (fastest - slowest) / 2;
            int hoursNeeded = hoursToFinish(piles, speed);

            if (hoursNeeded <= h) {
                fastest = speed - 1; // This speed works. Go more slowly
            } else {
                slowest = speed + 1; // This speed doesn't work. Go faster.
            }
        }

        return slowest;
    }

    private int getFastestEatingSpeed(int[] piles) {
        int max = 0;
        for (int pile : piles) max = Math.max(max, pile);
        return max;
    }

    private int hoursToFinish(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) total += (pile + speed - 1) / speed;
        return total;
        // (a + b - 1) / b works because it adds just enough to push any remainder over the boundary,
        //  but not enough to break exact divisions
        // Ceiling Division: division, then round UP to the nearest integer
    }
}
