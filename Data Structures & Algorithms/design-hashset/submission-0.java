class MyHashSet {
    private Map<Integer, Integer> set;

    public MyHashSet() {
        this.set = new HashMap<>();
    }
    
    public void add(int key) {
        this.set.put(key, key);    
    }
    
    public void remove(int key) {
        this.set.remove(key);
    }
    
    public boolean contains(int key) {
        if (this.set.containsKey(key)) return true;

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */