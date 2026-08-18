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
    public void reorderList(ListNode head) {
        // Find Midpoint
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Sever at midpoint
        ListNode secondHalf = slow.next; // 0 1 2 3 Sever 4 5 6
        slow.next = null;

        // Reverse list
        ListNode prev = null;
        ListNode curr = secondHalf;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode head2 = prev;

        // Stitch back together
        while (head != null && head2 != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;

            head.next = head2;
            head2.next = temp1;

            head = temp1;
            head2 = temp2;            
        }
    }
}
