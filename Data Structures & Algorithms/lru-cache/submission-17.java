class LRUCache {
    private final int maxCapacity;
    private int capacity = 0;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        // H <-> 1 <-> T
        node.prev.next = node.next; // H -> T
        node.next.prev = node.prev; // H <-> T
        
        insertAtHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            get(key);
            return; 
        } 
        Node node = new Node(key, value);
        insertAtHead(node);
        capacity++;
        cache.put(key, node);

        evict();
    }

    private void evict() {
        if (capacity > maxCapacity) {
            // Inital State H <-> 2 <-> 1 <-> T. Assume 2 is MRU after add. 1 is LRU
            Node temp = tail.prev; // 1
            temp.prev.next = tail; // H <-> 2 -> T.
            tail.prev = temp.prev; // H <-> 2 <-> T.
            capacity--;
            cache.remove(temp.key);
        }
        return;
    }

    private void insertAtHead(Node node) { // New Node: 1
        // Initial State H <-> T 
        Node temp = head.next; // T
        head.next = node; // H -> 1
        node.prev = head; // H <-> 1
        temp.prev = node; // H <-> 1 <- T
        node.next = temp; // H <-> 1 <-> T
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
