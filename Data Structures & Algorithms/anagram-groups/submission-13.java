class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) counts[s.charAt(i) - 'a']++;
            
            String key = Arrays.toString(counts);
            map.computeIfAbsent(key, k -> new ArrayList<>())
                .add(s);
        }

        return new ArrayList<>(map.values());
    }
}
