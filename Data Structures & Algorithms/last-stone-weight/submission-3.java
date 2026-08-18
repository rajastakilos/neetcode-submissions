class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int stone : stones) maxHeap.offer(stone);

        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll(); // biggest
            int stone2 = maxHeap.poll(); // second biggest

            if (stone1 == stone2) continue; 
            if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
