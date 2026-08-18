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
        ListNode dummy = new ListNode();
        ListNode resultHead = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int firstVal = l1 == null ? 0 : l1.val;
            int secondVal = l2 == null ? 0 : l2.val;
            int sum = firstVal + secondVal + carry;
            carry = sum / 10;
            ListNode nextNode =  new ListNode(sum % 10);
            dummy.next = nextNode;
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return resultHead.next;
    }
}

// % 10 answers: “What belongs in the ones place?”
// / 10 answers: “What spills over to the next column?”
