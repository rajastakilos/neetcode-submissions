class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();        
        for (String string : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < string.length(); i++) counts[string.charAt(i) - 'a']++;
            String key = Arrays.toString(counts);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(string);
        }

        return new ArrayList<>(result.values());
    }
}
