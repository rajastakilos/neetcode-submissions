class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(); // we do not yet know how many intervals the final answer will contai
        int i = 0;
        // newInterval = [10,12]
        // intervals = [[1,2], [3,5], [6,8]] // 10 > 2, 5, 8
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i++]);
        }

        // newInterval = [2,6]
        // intervals = [[3,5]]
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // intervals = [[1,2], [3,5], [10,12], [14,16]]
        // newInterval = [4,8]
        // [1,2] → before
        // [3,5] → overlaps → merge
        // [10,12] → no longer overlaps → stop merge
        while (i < intervals.length) result.add(intervals[i++]); // [10,12], [14,16]

        return result.toArray(new int[result.size()][]);
    }
}
