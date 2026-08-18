class KthLargest { // Remember Kth element is the smallest element in a top k set.
    PriorityQueue<Integer> minHeap; 
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(); // By default Java's implementation of a min heap.
        this.k = k;
        this.populateMinHeap(nums);
    }

    public int add(int val) {
        this.minHeap.add(val);
        if (this.minHeap.size() > this.k) this.minHeap.poll(); // Removes smallest value.

        return this.minHeap.peek();
    }

    private void populateMinHeap(int[] nums) {
        for (int num : nums) {
            this.minHeap.add(num);
            if (this.minHeap.size() > this.k) this.minHeap.poll();
        }
    }
}
// Time: add, poll are O (log k). For populating: O(n * log k).
    // PriorityQueue is backed by a binary heap. 
    // Binary Heap is a (1) a complete BST, (2) stored in an array, (3) with heap property
        // parent <= children. 
// Space: O(k). We only ever store at most k elements in the minHeap.
