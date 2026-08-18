class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build adj list
        // t[ sourceNode, targetNode, time ]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                .add(new int[]{t[1], t[2]});
        }

        // 2. PriorityQueue
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        minHeap.offer(new int[]{0, k});// [timeToReachThisNode, node]

        // 3. 
        Set<Integer> visited = new HashSet<>();
        int maxTime = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int node = curr[1];

            if (visited.contains(node)) continue;
            visited.add(node);

            maxTime = time;
            
            if (!graph.containsKey(node)) continue;
            
            for (int[] next : graph.get(node)) {
                if (!visited.contains(next[0]));
                minHeap.offer(new int[]{time + next[1], next[0]});
            }
        }

        return visited.size() == n ? maxTime : -1;
    }
}
