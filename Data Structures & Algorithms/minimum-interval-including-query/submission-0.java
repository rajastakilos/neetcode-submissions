class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)-> a[1]-a[0]-b[1]+b[0]);

        for(int i = 0; i<intervals.length; i++){
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for(int q: queries){
            int res = -1;
            for(int i = 0; i<intervals.length; i++){
                if (intervals[i][0] <= q && intervals[i][1] >= q){
                    res = intervals[i][1] - intervals[i][0] + 1;
                    break;
                }
            }
            ans[idx++] = res;
        }
        return ans;
    }
}