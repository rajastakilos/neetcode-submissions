class MyHashSet {
    private Integer[] set = new Integer[1000001];

    public MyHashSet() {
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = null;
    }
    
    public boolean contains(int key) {
        if (set[key] != null) return true;

        return false;
    }

    // private static class Node {
    //     int val;
    //     Node next;
    // }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */