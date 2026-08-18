class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();


        for (String string : strs) {
            int[] counts = new int[26];

            for (int i = 0; i < string.length(); i++) counts[string.charAt(i) - 'a']++;
            String key = Arrays.toString(counts);
            
            anagrams.putIfAbsent(key, new ArrayList());
            anagrams.get(key).add(string);
        }

        // return new ArrayList<>(anagrams.values());  
        result.addAll(anagrams.values());
        return result;
    }
}
