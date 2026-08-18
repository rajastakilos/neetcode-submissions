class MedianFinder {
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b, a)
        ); // [3, 2, 1]
    PriorityQueue<Double> minHeap = new PriorityQueue<>(); // [7, 8, 9]

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        maxHeap.offer((double) num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
