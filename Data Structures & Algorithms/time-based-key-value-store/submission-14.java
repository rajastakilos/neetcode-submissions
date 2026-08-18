class TimeMap {
    private final Map<String, List<Entry>> store = new HashMap<>();
    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        this.store
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        List<Entry> entries = this.store.get(key);
        if (entries == null) return ans;

        int left = 0;
        int right = entries.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (entries.get(mid).timestamp <= timestamp) {
                left = mid + 1;
                ans = entries.get(mid).value; // closest.
            } else {
                right = mid - 1;
            }
        }

        return ans;
        
    }

    private static class Entry {
        String value;
        int timestamp;
        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
