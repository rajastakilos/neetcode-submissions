class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> unlocks = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            unlocks.add(new ArrayList<>());
        }

        int[] preReqCount = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];

            preReqCount[course]++;
            unlocks.get(prereq).add(course);
        }

        Queue<Integer> available = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (preReqCount[course] == 0) available.add(course);
        }

        int taken = 0;
        while (!available.isEmpty()) {
            int course = available.poll();
            taken++;

            for (int unlockedCourse : unlocks.get(course)) {
                preReqCount[unlockedCourse]--;
                if (preReqCount[unlockedCourse] == 0) {
                    available.add(unlockedCourse);
                }
            }

        }

        return taken == numCourses;
    }
}
