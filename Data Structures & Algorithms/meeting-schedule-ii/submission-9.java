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

// Greedy: When a new meeting starts, 
// reuse the room that frees up the earliest, if that room is available.
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) minHeap.poll();

            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}

// This is the same flavor as interval greedy problems:

// keeping the room that frees earliest leaves the most flexibility for future meetings

// If you reused a later-ending free room instead, that can only make future placement harder, never easier.

// So “reuse the earliest available room” is the locally best choice that also preserves the most future options.
