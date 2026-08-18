class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int finish = 0;
        int[] output = new int[numCourses]; // COURSES2.
        while (!q.isEmpty()) {
            int node = q.poll();
            output[finish] = node; // COURSES2.
            finish++;

            for (int n : adj.get(node)) {
                inDegree[n]--;
                if (inDegree[n] == 0) q.offer(n);
            }
        }

        if (finish != numCourses) return new int[0]; // COURSES2.
        return output;
    }
}
