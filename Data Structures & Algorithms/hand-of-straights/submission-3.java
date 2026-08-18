class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (Integer card : hand) count.put(card, count.getOrDefault(card, 0) + 1);

        Arrays.sort(hand);

        for (Integer start : hand) {
            if (count.get(start) == 0) continue;

            for (Integer card = start; card < start + groupSize; card++) {
                Integer remaining = count.get(card);
                if (remaining == null || remaining == 0) return false;

                count.put(card, remaining - 1);
            }
        }

        return true;
    }
}

// The smallest remaining card cannot be placed in the middle or at the end of a straight. 
// It must start one.
