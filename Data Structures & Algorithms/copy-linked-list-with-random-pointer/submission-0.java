/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        // 1. Interweave new list with old list.
        Node newHead = head;
        while (newHead != null) {
            Node temp = newHead.next;
            Node copyNode = new Node(newHead.val);
            newHead.next = copyNode;
            copyNode.next = temp;
            newHead = temp;
        }

        // 2. Add random pointers
        Node original = head;
        Node copy = head.next;
        while (original != null) {
            copy.random = original.random == null ? null : original.random.next;
            original = original.next.next;
            copy = (original != null) ? original.next : null;
        }

        // 3. Unweave original from copy
        original = head;
        copy = head.next;
        Node result = copy; // Return head of copy;

        while (original != null) {
            original.next = original.next.next;
            copy.next = original.next == null ? null : copy.next.next;

            original = original.next;
            copy = copy.next;
        }

        return result;
    }
}
