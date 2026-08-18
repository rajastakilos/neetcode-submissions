class Solution {
    public int minCostConnectPoints(int[][] points) {
        int node = 0;
        int[] dist = new int[points.length];
        boolean[] visit = new boolean[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE); // 
        int edges = 0;
        int result = 0;

        while (edges < points.length - 1) {
            visit[node] = true;
            int nextNode = -1;
            for (int i = 0; i < points.length; i++) {
                if (visit[i]) continue;

                int curDist = Math.abs(points[i][0] - points[node][0]) +
                              Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], curDist);

                if (nextNode == -1 || dist[i] < dist[nextNode]) nextNode = i;
            }
            result += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return result;
    }
}
