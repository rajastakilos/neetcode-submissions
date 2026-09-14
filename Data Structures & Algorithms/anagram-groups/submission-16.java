class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String string : strs) {
            int[] counts = new int[26];

            for (int i = 0; i < string.length(); i++) {
                counts[string.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(counts);
            
            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(string);
            } else {
                anagrams.put(key, new ArrayList<>());
                anagrams.get(key).add(string);
            }
        }

        return new ArrayList<>(anagrams.values());
    }
}
