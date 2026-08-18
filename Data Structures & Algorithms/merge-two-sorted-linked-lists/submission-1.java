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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return list1;
        if (list1 == null && list2 != null) return list2;
        if (list1 != null && list2 == null) return list1;

        // ListNode newHead = list1.val <= list2.val ? list1 : list2;
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
            // if (list1.val == list2.val)
            // if (list1.val <= list2.val) {
            //     ListNode temp = list1.next;
            //     list1.next = list2;
            //     list1 = temp;  
            // } 
            // else {
            //     ListNode temp = list2.next;
            //     list2.next = list1;
            //     list2 = temp;
            // }
        }

        while (list1 != null) {
            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;
        }

        while (list2 != null) {
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }

        return newHead.next;
    }
}