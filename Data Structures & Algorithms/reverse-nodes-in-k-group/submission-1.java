/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while (true) {
            ListNode kth = getKthNode(prev, k);
            if (kth == null) break;

            ListNode curr = prev.next;
            ListNode next = kth.next;
            reverse(curr, next);
            
            prev.next = kth;
            prev = curr;

        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }

        return start;
    }

    // Reverse nodes from start up to (but not including) end
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        ListNode curr = start;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
}
