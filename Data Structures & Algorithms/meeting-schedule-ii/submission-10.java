/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            if (!minHeap.isEmpty() && 
                minHeap.peek() <= meeting.start) minHeap.poll();

            minHeap.offer(meeting.end);
        }

        return minHeap.size();
    }
}
