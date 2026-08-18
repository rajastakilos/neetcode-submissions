class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int heapLimit;

    public KthLargest(int k, int[] nums) {
        this.heapLimit = k;
        this.minHeap = buildMinHeap(k, nums);
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (this.minHeap.size() > this.heapLimit) this.minHeap.poll();
        return this.minHeap.peek();
    }

    private PriorityQueue<Integer> buildMinHeap(int k, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap;
    }
}
