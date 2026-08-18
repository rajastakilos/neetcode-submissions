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
        // 1. Floyd's T and H
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // if (slow == fast) return false. 
        }

        // 2. Sever
        ListNode secondHalf = slow.next;
        slow.next = null;

        // 3. Reverse
        ListNode prev = null;
        ListNode curr = secondHalf;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode head2 = prev;

        // 4. Stitch
        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;

            head.next = head2;
            head2.next = tmp1;

            head = tmp1;
            head2 = tmp2;
        }
    }
}
