class MyHashSet {
    private boolean[] set = new boolean[1000001];

    public MyHashSet() {
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        if (set[key]) return true;

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