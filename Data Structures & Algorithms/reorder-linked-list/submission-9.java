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
        // 1. Floyd's
                       // S
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
                                      // F           
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Sever second list
        // 5 -> 6 -> 7
        ListNode secondHalf = slow.next;
        slow.next = null;

        // 3. Reverse LL
        // 7 -> 6 -> 5
        ListNode head2 = null;
        ListNode curr = secondHalf;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = head2;
            head2 = curr;
            curr = temp;
        }

        // 4. ZigZag Stitch
        // 1 -> 2 -> 3 -> 4
        // 7 -> 6 -> 5
        ListNode head1 = head;
        
        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            
            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }

    }
}
