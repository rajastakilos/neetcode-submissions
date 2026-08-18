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

// Invariant: Max-heap always contains all remaining stones; root is the heaviest.
// Time: O(n * log n) when building the maxHeap. O(log n) when removing items.  
// Space: maxHeap: O(n) where n is the number of stones in the input.

// Max Heap notes:
// Parent > Children. left and right order don't matter. 
// Build Heap: O(n * log n) Building the heap is O(n log n) because we insert n elements individually, and each insertion can take up to O(log n) due to bubbling up the heap.
// Insertion into Heap: O(n) Start from the last non-leaf node
    // Sink elements downward
    // Most nodes are near the bottom → very cheap
    // Only a few nodes are near the top → expensive
    // This distributes work unevenly and sums to O(n).