class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build Adj list.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>()) // source
                .add(new int[]{t[1], t[2]}); // target and time.
        }

        // 2. minHeap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // Good idea to use Integer.compare
        );
        minHeap.offer(new int[]{0, k}); // So lowest possible time and k?

        Set<Integer> visited = new HashSet<>();
        int maxTime = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0]; // 
            int node = curr[1];

            if (visited.contains(node)) continue; // Why?
            visited.add(node);
            maxTime = time;

            if (!graph.containsKey(node)) continue; // Why?

            for (int[] next : graph.get(node)) {
                if (!visited.contains(next[0])) {
                    minHeap.offer(new int[]{ time + next[1], next[0]});
                }
            }
        }

        return visited.size() == n ? maxTime : -1;
        
    }
}
