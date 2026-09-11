class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int maxHeapSize;

    public KthLargest(int k, int[] nums) {
        this.maxHeapSize = k;
        this.minHeap = buildHeap(nums);
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (minHeap.size() > maxHeapSize) this.minHeap.poll();
        return this.minHeap.peek();
    }

    private PriorityQueue<Integer> buildHeap(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > this.maxHeapSize) heap.poll();
        }

        return heap;
    }
}
