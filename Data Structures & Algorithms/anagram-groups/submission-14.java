class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) counts[str.charAt(i) - 'a']++;
            String key = Arrays.toString(counts);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
