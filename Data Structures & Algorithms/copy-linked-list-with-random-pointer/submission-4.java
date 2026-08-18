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

        // 1. Interweave copies with originals. 
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next; // Point copy to node after original.
            curr.next = copy; // Point original to the copy. 

            curr = copy.next; // Next original node is after copy.
        }

        // Set random pointers.
        curr = head;
        while (curr != null) {
            Node copy = curr.next; // Find a copy
            copy.random = curr.random == null ? null : curr.random.next;

            curr = copy.next;
        }
        
        // Separate
        curr = head;
        Node copiedHead = head.next;

        while (curr != null) {
            Node copy = curr.next;
            Node nextOriginal = copy.next;

            curr.next = nextOriginal;
            copy.next = nextOriginal == null ? null : nextOriginal.next;

            curr = nextOriginal;
        }

        return copiedHead;
    }
}
