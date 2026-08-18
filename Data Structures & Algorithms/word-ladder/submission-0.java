class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();
        front.add(beginWord);
        back.add(endWord);

        int steps = 1;

        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                Set<String> temp = front;
                front = back;
                back = temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : front) {
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[i] = c;
                        String nei = new String(arr);

                        if (back.contains(nei)) return steps + 1;
                        if (dict.contains(nei)) {
                            next.add(nei);
                            dict.remove(nei);
                        }
                    }

                    arr[i] = original;
                }
            }

            front = next;
            steps++;
        }

        return 0;
    }
}
