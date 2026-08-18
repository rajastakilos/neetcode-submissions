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
 // P  C    N
 //    1 -> 2 -> 3 -> 4
 //    P    C    N
 //    1 <- 2 -> 3 -> 4

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; // Reverse current node 
            prev = curr; // Move previous forward.
            curr = temp; // Move current forward.
        }

        return prev;
    }
}
