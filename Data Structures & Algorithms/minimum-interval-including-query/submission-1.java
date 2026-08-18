class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; // query value
            sortedQueries[i][1] = i;          // original index
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        // [intervalSize, intervalEnd]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int intervalIndex = 0;

        for (int[] queryPair : sortedQueries) {
            int query = queryPair[0];
            int originalIndex = queryPair[1];

            // Add all intervals that have started by now
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int start = intervals[intervalIndex][0];
                int end = intervals[intervalIndex][1];
                int size = end - start + 1;

                minHeap.offer(new int[]{size, end});
                intervalIndex++;
            }

            // Remove intervals that already ended before this query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            result[originalIndex] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
}