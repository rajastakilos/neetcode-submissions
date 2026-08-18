class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int slowest = 1; // speed can never be zero
        int fastest = getFastestEatingSpeed(piles);

        while (slowest <= fastest) {
            int speed = slowest + (fastest - slowest) / 2;
            int hoursNeeded = hoursToFinishPiles(piles, speed);

            if (hoursNeeded <= h) {
                fastest = speed - 1;
            } else {
                slowest = speed + 1;
            }            
        }

        return slowest;
    }

    private int getFastestEatingSpeed(int[] piles) {
        int max = 0;
        for (int pile : piles) max = Math.max(max, pile);
        return max;
    }

    private int hoursToFinishPiles(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) total += (pile + speed - 1) / speed;
        return total;
    }

    
}
