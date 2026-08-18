class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) count.put(card, count.getOrDefault(card, 0) + 1);

        Arrays.sort(hand);

        for (Integer start : hand) {
            if (count.get(start) == 0) continue; // Ex. [1,2,2,3,3,4]. 1 gets used in first hand. 

            for (Integer i = start; i < start + groupSize; i++) {
                Integer remaining = count.get(i); // Integer instead of int.
                
                if (remaining == null || 
                    remaining == 0) return false;

                count.put(i, remaining - 1);
            }
        }

        return true;
    }
}