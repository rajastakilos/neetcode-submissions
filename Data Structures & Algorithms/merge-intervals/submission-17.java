class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            // [1, 3] [2, 4] -> [1, 4]
            int[] next = intervals[i];
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else { // [1, 3] [4, 5]
                current = next;
                merged.add(current);
            }
        }       

        return merged.toArray(new int[merged.size()][]);
    }
}
