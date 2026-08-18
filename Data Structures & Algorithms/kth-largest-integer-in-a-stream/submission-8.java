class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int maxHeapSize;
    public KthLargest(int k, int[] nums) {
        this.maxHeapSize = k;
        this.minHeap = buildMinHeap(nums);
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (minHeap.size() > this.maxHeapSize) this.minHeap.poll();
        return this.minHeap.peek();
    }

    private PriorityQueue<Integer> buildMinHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > this.maxHeapSize) minHeap.poll();
        }

        return minHeap;
    }
}
