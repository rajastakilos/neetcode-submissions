class MedianFinder {
    PriorityQueue<Double> maxHeap; // [3, 2, 1]
    PriorityQueue<Double> minHeap; // [7, 8, 9]

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b, a)
        );
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer((double) num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.size() > minHeap.size() ?
                maxHeap.peek() : minHeap.peek();
        }
    }
}
