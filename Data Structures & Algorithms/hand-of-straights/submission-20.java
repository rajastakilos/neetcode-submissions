class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        int[] count = new int[1001];

        for (int card : hand) count[card]++;

        for (int i = 0; i <= 1000; i++) {
            while (count[i] > 0) {
                for (int j = i; j < i + groupSize; j++) {
                    if (j > 1000 || count[j] == 0) return false;
                    count[j]--;
                }
            }
        }

        return true;
    }
}
// [0, 1, 2, 1, 1, 0, 1, 1, 1, 0] 

// [1, 2, 2, 3, 3, 4, 4, 5] // 4

// Start: [0, 1, 2, 2, 2, 1, 0]
// Iteration 1: [0, 0, 1, 1, 1, 1, 0]


