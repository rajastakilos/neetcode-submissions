class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int slowest = 1; // 1
        int fastest = getFastestSpeed(piles); // biggest pile

        while (slowest <= fastest) {
            int speed = slowest + (fastest - slowest) / 2;
            int eatingTime = getEatingTime(piles, speed);    

            if (eatingTime <= h) {
                fastest = speed - 1; // go slower
            } else {
                slowest = speed + 1; // go faster
            }
        }

        return slowest;
    }

    private int getFastestSpeed(int[] piles) {
        int max = 0;
        for (int pile : piles) max = Math.max(max, pile);
        return max;
    }

    private int getEatingTime(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) total += (pile + speed - 1) / speed;
        return total;
    }
}
