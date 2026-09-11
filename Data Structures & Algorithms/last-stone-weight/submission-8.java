class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        for (int stone : stones) maxHeap.offer(stone);

        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();

            if (heaviest != secondHeaviest) {
                maxHeap.offer(heaviest - secondHeaviest);
            }  
        }

        return maxHeap.size() > 0 ? maxHeap.peek() : 0;

    }
}
