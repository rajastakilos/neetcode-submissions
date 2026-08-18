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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Dummy to handle a single node list situation.
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // 2. Move dummy forward 
        for (int i = 0; i < n + 1; i++) { // n + 1 because dummy makes our head one node longer.
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}

// “I use a dummy node so I can always delete slow.next without special cases. 
// To ensure slow lands right before the node to remove, 
// I maintain a gap of n + 1 between the pointers.”