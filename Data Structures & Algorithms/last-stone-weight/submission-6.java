class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        for (int stone : stones) maxHeap.offer(stone);

        while (maxHeap.size() > 1) {
            int heaviestStone = maxHeap.poll();
            int secondHeaviestStone = maxHeap.poll();

            if (heaviestStone == secondHeaviestStone) continue;
            if (secondHeaviestStone < heaviestStone) {
                maxHeap.offer(heaviestStone - secondHeaviestStone);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
