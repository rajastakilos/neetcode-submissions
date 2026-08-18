class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();


        for (String string : strs) {
            int[] counts = new int[26];

            for (int i = 0; i < string.length(); i++) counts[string.charAt(i) - 'a']++;
            String key = Arrays.toString(counts);
            
            if (anagrams.containsKey(key)) {
                List<String> strings = anagrams.get(key);
                strings.add(string);
                anagrams.put(key, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(string);
                anagrams.put(key, strings);
            }
        }

        return new ArrayList<>(anagrams.values());
    }
}
