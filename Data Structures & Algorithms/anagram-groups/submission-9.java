class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] stringToDigits = new int[26];

            for (int i = 0; i < str.length(); i++) {
                stringToDigits[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(stringToDigits);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
