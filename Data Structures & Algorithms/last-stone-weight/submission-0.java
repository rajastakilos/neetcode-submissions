class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) maxHeap.add(stone);
        
        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();

            if (heaviest != secondHeaviest) {
                int newStone = heaviest - secondHeaviest;
                maxHeap.add(newStone);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
