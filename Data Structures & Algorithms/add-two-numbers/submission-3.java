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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode resultNode = current;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int firstVal = l1 == null ? 0 : l1.val;
            int secondVal = l2 == null ? 0 : l2.val;

            int sum = firstVal + secondVal + carry;
            carry = sum / 10;

            ListNode nextNode =  new ListNode(sum % 10);
            current.next = nextNode;
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return resultNode.next;
    }
}
// Time: O(m + n). We touch each node in each linked list one.
// Space: O(x). x represents the digits that result from the addition. 

// % 10 answers: “What belongs in the ones place?”
// / 10 answers: “What spills over to the next column?”
