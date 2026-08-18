class TimeMap {
    private Map<String, List<Entry>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.store
            .computeIfAbsent(key, k -> new ArrayList<Entry>())
            .add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String answer = "";
        List<Entry> history = store.get(key);
        if (history == null) return answer;

        int left = 0;
        int right = history.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (history.get(mid).timestamp <= timestamp) {
                answer = history.get(mid).value; // the most recent timestamp that is ≤ the query timestamp
                left = mid + 1; // Maybe a later one works
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
