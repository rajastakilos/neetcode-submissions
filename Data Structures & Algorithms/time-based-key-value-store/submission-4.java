class TimeMap {
    private final Map<String, List<Entry>> map = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(timestamp, value);
        List<Entry> entryList = this.map.getOrDefault(key, new ArrayList<>());
        entryList.add(entry);
        this.map.put(key, entryList);
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = this.map.get(key);
        if (list == null) return ""; // Use this to avoid double get from containsKey and get.

        return binarySearch(list, timestamp);              
    }

    private String binarySearch(List<Entry> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String closestValSoFar = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentTimestamp = list.get(mid).time;

            if (timestamp == currentTimestamp) return list.get(mid).value;

            if (timestamp < currentTimestamp) {
                right = mid - 1;

            } else {
                closestValSoFar = list.get(mid).value; // Closest value without going over.
                left = mid + 1;
            }
        }

        return closestValSoFar; // Closest without going over. 
    }

    private static class Entry { // A non-static inner class secretly holds a reference to the outer TimeMap instance.
        int time;
        String value;
        Entry(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }
}
