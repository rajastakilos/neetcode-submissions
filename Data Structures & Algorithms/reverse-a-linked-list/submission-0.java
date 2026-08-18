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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        while (curr != null) { // 0 -> 1 -> 2. 
            ListNode nextCurrent = curr.next; // 2
            curr.next = prev; // 1 -> 0
            prev = curr; // 1
            curr = nextCurrent; // 2           
        }

        return prev;
    }
}
