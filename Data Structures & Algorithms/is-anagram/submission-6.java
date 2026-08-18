class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map1.get(c) == null) {
                map1.put(c, 1);
            } else {
                Integer sum = map1.get(c);
                map1.put(c, sum + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map2.get(c) == null) {
                map2.put(c, 1);
            } else {
                Integer sum = map2.get(c);
                map2.put(c, sum + 1);
            }
        }

        if (map1.keySet().size() != map2.keySet().size()) return false;

        for (Character key : map1.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) return false;
        }

        return true;
    }
}
