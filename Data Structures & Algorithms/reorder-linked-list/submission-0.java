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
        // 1. Find the midpoint using a slow and fast pointer.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null; // Store head for reversed second half.
        ListNode curr = slow.next; // Reverse list after the midpoint we found.
        slow.next = null; // Sever lists.

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Re-order both lists into one list.
        ListNode oldHead = head;
        ListNode reversedHead = prev;

        while (oldHead != null && reversedHead != null) {
            ListNode temp = oldHead.next;
            oldHead.next = reversedHead;

            ListNode temp2 = reversedHead.next;
            reversedHead.next = temp;

            oldHead = temp;
            reversedHead = temp2;
        }
    }
}
