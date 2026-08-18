class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum eat speed is one banana per hour.

        int right = Integer.MIN_VALUE;
        for (int pile : piles) right = Math.max(right, pile);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;  //Math.ceilDiv(piles[i], mid);
            }

            if (totalHours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
