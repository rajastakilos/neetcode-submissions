class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) count.put(card, count.getOrDefault(card, 0) + 1);

        Arrays.sort(hand);

        for (int start : hand) {
            if (count.get(start) == 0) continue;

            for (int card = start; card < start + groupSize; card++) {
                int remaining = count.getOrDefault(card, 0);
                if (remaining == 0) return false;

                count.put(card, remaining - 1);
            }
        }

        return true;
    }
}
