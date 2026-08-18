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
        ListNode slow = head;
        ListNode fast = head;
        // 1.  Floyd's T and H: Get mid point.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null; // Sever lists. Needed?

        // 2. Reverse LL: Reverse everything from midpoint to the end of the list.
        ListNode head2 = null;
        ListNode curr = middle;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = head2;
            head2 = curr;
            curr = temp;
        }

        // 3. Create new list
        ListNode prev = head2;
        ListNode head1 = head;
        
        while (head1 != null && head2 != null) {
            ListNode tmp = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp;
            
            head1 = tmp;
            head2 = tmp2;
        }
    }
}
