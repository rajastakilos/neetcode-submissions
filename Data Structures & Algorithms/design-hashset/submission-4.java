class MyHashSet {
    Node[] bucket = new Node[4];
    public MyHashSet() {
    }
    
    public void add(int key) {
        int bucketValue = key % bucket.length;
        Node node = new Node(key, null);

        if (bucket[bucketValue] == null) {
            bucket[bucketValue] = node;
        } else {
            Node current = bucket[bucketValue];
            Node temp = current;

            while (current.next != null) { // VIP
                if (current.val == key) return; // VIP
                current = current.next;
            }

            if (current.val == key) return; // VIP
            current.next = node;
            bucket[bucketValue] = temp;
        }
    }
    
    public void remove(int key) {
        int bucketValue = key % bucket.length;

        Node current = bucket[bucketValue];
        Node prev = null;

        while (current != null) {
            if (current.val == key) {
                if (prev == null) { // VIP: Remove head
                    bucket[bucketValue] = current.next;
                } else { // VIP: Middle or Tail Node
                    prev.next = current.next;
                }
                return;
            }

            prev = current;
            current = current.next;
        }
    }
    
    public boolean contains(int key) {
        int bucketValue = key % bucket.length;
        if (bucket[bucketValue] == null) return false;

        Node current = bucket[bucketValue];

        while (current != null) {
            if (current.val == key) return true;
            current = current.next;
        }

        return false;
    }

    private static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */