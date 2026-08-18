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

        // end times of all meetings currently using rooms
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            // If the new meeting starts after the earliest room (ends) becomes free, reuse that room.
            if (!minHeap.isEmpty() && 
                meeting.start >= minHeap.peek()) minHeap.poll(); // peek: earliest end time. 

            minHeap.offer(meeting.end); // Reuse room.
        }

        return minHeap.size();
    }
}
