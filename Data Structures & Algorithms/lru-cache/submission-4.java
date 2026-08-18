class LRUCache {
    private final int maxSize;
    private int capacity = 0;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) return -1;
        
        Node node = this.cache.get(key);
        // Remove value from it's current position. 
        // Ex. Get 1. H <-> 1 <-> 2 <-> T
        node.prev.next = node.next; // H -> 2 
        node.next.prev = node.prev; // H <- 2

        // Insert recently touched node at the head position.
        // Ex. H -> 2 -> T. Ex. Get 1. Removed it. Now insert in front of head.
        Node temp = this.head.next; // Store reference to 2.
        this.head.next = node; // H -> 1.
        node.prev = this.head; // H <- 1.
        node.next = temp; // 1 -> 2
        temp.prev = node; // 1 <- 2

        return node.value;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.cache.get(key).value = value;
            this.get(key);
            return;
        }
        Node node = new Node(key, value);
        this.cache.put(key, node);
        this.capacity++;
        Node temp = this.head.next; // H -> *
        this.head.next = node; // H -> N
        node.prev = this.head; // H <- N
        node.next = temp; // H -> N -> *
        temp.prev = node; // N <- *

        this.evict();        
    }

    private void evict() {
        if (this.capacity > this.maxSize) {
            Node temp = this.tail.prev; // * <- 1 <- T
            this.tail.prev = temp.prev; // * <- T
            temp.prev.next = this.tail; // * -> T
            cache.remove(temp.key);
            this.capacity--;
        }
    }

    private static class Node { // No class outside of LRUCache needs a reference to it.
        public int key;
        public int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


