class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks) count[task - 'A']++; // How often does each task appear?

        Arrays.sort(count); // Sorting places largest frequency at the end.
        int max = count[25];  // Index 25 is last one. 

int gaps = max - 1;
int idleSlots = gaps * n;

// Try to fill the idle slots with other tasks
for (int i = 24; i >= 0; i--) {
    int fill = Math.min(gaps, count[i]);
    idleSlots -= fill;
}

// If we overfilled, no idle time is needed
int remainingIdle = Math.max(0, idleSlots);

return tasks.length + remainingIdle;
    }
}
