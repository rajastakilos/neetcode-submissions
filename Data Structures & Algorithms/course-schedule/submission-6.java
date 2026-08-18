class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++; // This course has a prerequisite
            adj.get(pre[1]).add(pre[0]); // Prereq → course it unlocks
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i); // This course has no prerequisites to begin with. 
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;

            for (int n : adj.get(node)) {
                inDegree[n]--;
                if (inDegree[n] == 0) q.add(n);
            }
        }

        return finish == numCourses;
    }
}
