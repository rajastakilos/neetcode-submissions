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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0, head);

        // Find node before segment start.
        ListNode beforeLeft = dummy;
        for (int i = 1; i < left; i++) beforeLeft = beforeLeft.next;

        // Get segments:
        ListNode start = beforeLeft.next;
        ListNode end = start;
        for (int i = left; i < right; i++) end = end.next;

        // save node after right and cut off everything after end. 
        ListNode afterRight = end.next;
        end.next = null;

        // reverse list
        ListNode reversedHead = reverseList(start);

        // stitch 
        beforeLeft.next = reversedHead;
        start.next = afterRight;

        return dummy.next;

    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}