class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (anagramMap.containsKey(sorted)) {
                List<String> existingSublist = anagramMap.get(sorted);
                existingSublist.add(str);
            } else {
                List<String> newSublist = new ArrayList<>();
                newSublist.add(str);
                anagramMap.put(sorted, newSublist);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }
}
// Time: O(n * k log k). k log k is for sorting each string
// Space: O(n * k)
