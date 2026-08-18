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

        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) { // 0 -> 1 -> 2. 
            ListNode temp = curr.next; // 2
            curr.next = prev; // 1 -> 0
            prev = curr; // 1
            curr = temp; // 2           
        }

        return prev;
    }
}
// Time: O(n). We must process each node once while reversing pointers.
// Space: O(1). We create no new collections. We just initialize pointers.