class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int stone : stones) maxHeap.offer(stone);

        while (true) {
            if (maxHeap.size() == 1 || maxHeap.size() == 0) break;
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 - stone2 == 0) {
                continue;
            } else {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0; 
    }
}
